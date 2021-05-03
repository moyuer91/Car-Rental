package com.zjy.job.carrental.service;

import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.vo.CarModelsQueryVo;
import com.zjy.job.carrental.vo.OrderVo;

import java.util.List;

public interface ICarRentalService {
    /**
     * 预约车辆
     * @param order 订单信息
     * @return
     */
    OrderVo reserveCarWithReentrantLock(OrderVo order) throws ServiceException;
}
