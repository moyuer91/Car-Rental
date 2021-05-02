package com.zjy.job.carrental.service;

import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.vo.OrderVo;

import java.util.List;

public interface ICarRentalService {
    /**
     * 获取所有车型信息
     * @param types
     * @return
     */
    List<CarModel> getCarModels(List<String> types);

    /**
     * 根据车型id获取车型详情
     * @param carModelid 成型id
     * @return
     */
    CarModel getCarModelById(Integer carModelid);

    /**
     * 预约车辆
     * @param order 订单信息
     * @return
     */
    OrderVo reserveCar(OrderVo order) throws ServiceException;
}
