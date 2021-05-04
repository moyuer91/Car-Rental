package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.common.annotation.SysLog;
import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.common.lock.ServiceLock;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.domain.Order;
import com.zjy.job.carrental.mapper.ICarModelExtendMapper;
import com.zjy.job.carrental.mapper.ICarModelMapper;
import com.zjy.job.carrental.service.ICarRentalService;
import com.zjy.job.carrental.service.IOrderService;
import com.zjy.job.carrental.service.IStorageService;
import com.zjy.job.carrental.vo.CarModelsQueryVo;
import com.zjy.job.carrental.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 租车入口服务，通过调度库存和订单服务，完成租车预约功能
 */
@Slf4j
@Service
public class CarRentalService implements ICarRentalService {
    @Autowired
    private CarModelService carModelService;

    @Autowired
    private IStorageService storageService;

    @Autowired
    private IOrderService orderService;

    /**
     * 预约车辆，可重入锁版本
     * @param order 订单信息
     * @return
     */
    @ServiceLock(description = "可重入锁，保证不会超卖")
    @Transactional(rollbackFor = Exception.class)
    public OrderVo reserveCarWithReentrantLock(OrderVo order) throws ServiceException {
        // 0. 校验参数合法性
        if(order.getStartTime()==null || order.getEndTime()==null){
            log.error("订单起止时间不能为空");
            throw new ServiceException("订单起止时间不能为空");
        }
        CarModel carModel = carModelService.getCarModelById(order.getModelId());
        if(carModel==null){
            log.error("没有找到指定车型");
            throw new ServiceException("没有找到指定车型");
        }

        // 1. 校验库存
        if(!storageService.checkStorage(order)){
            log.error("没有库存,预定失败");
            throw new ServiceException("没有库存，预定失败");
        }

        // 2. 生成订单
        OrderVo newOrder = orderService.createOrder(order);

        // 3. 扣减库存
        storageService.reduceStorage(order);
        log.info("预定成功,订单信息：",order);
        return newOrder;
    }
}
