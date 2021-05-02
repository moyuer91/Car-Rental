package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.domain.Order;
import com.zjy.job.carrental.enumerate.OrderStatusEnum;
import com.zjy.job.carrental.mapper.IOrderMapper;
import com.zjy.job.carrental.service.IOrderService;
import com.zjy.job.carrental.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    IOrderMapper orderMapper;

    @Override
    public OrderVo createOrder(OrderVo orderVo) {
        OrderVo result = new OrderVo();
        // 1. 生成订单号
        String orderNo = RandomUtil.generateOrderCode();

        // 2. 插入新订单
        Order order = new Order();
        BeanUtils.copyProperties(orderVo,order);
        order.setOrderNo(orderNo);
        order.setStatus(OrderStatusEnum.TOPAY.getKey());
        order.setCreateUser(orderVo.getUserId());
        int id = orderMapper.insert(order);
        BeanUtils.copyProperties(result,order);
        result.setId(id);
        return result;
    }

    @Override
    public List<OrderVo> getOrdersByTimeSlot(Integer startTime, Integer endTime) {

        return null;
    }

}
