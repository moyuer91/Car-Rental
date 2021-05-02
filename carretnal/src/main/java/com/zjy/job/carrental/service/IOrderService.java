package com.zjy.job.carrental.service;

import com.zjy.job.carrental.vo.OrderVo;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    /**
     * 根据页面表单创建订单
     * @param order 页面填写的订单信息
     * @return
     */
    OrderVo createOrder(OrderVo order);

    /**
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderVo> getOrdersByTimeSlot(Integer startTime, Integer endTime);
}
