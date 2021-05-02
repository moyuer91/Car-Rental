package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.domain.Order;
import com.zjy.job.carrental.mapper.ICarModelExtendMapper;
import com.zjy.job.carrental.mapper.ICarModelMapper;
import com.zjy.job.carrental.service.ICarRentalService;
import com.zjy.job.carrental.service.IOrderService;
import com.zjy.job.carrental.service.IStorageService;
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
    private ICarModelMapper ICarModelMapper;

    @Autowired
    private ICarModelExtendMapper ICarModelExtendMapper;

    @Autowired
    private IStorageService storageService;

    @Autowired
    private IOrderService orderService;

    @Override
    public List<CarModel> getCarModels(List<String> types) {
        log.info("getCarModels params:",types);
        return ICarModelMapper.selectAll();
    }

    @Override
    public CarModel getCarModelById(Integer id) {
        log.info("getCarModelById params:",id);
        return ICarModelExtendMapper.selectByCondition1(id);
    }

    /**
     * 预约车辆，需要考虑并发
     * @param order 订单信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public OrderVo reserveCar(OrderVo order) throws ServiceException {
        // 1. 校验库存
        if(!storageService.checkStorage(order)){
            log.error("没有库存");
            throw new ServiceException("没有库存了");
        }

        // 2. 生成订单
        OrderVo newOrder = orderService.createOrder(order);
        return newOrder;
    }
}
