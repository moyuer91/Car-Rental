package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.common.RandomUtil;
import com.zjy.job.carrental.domain.Order;
import com.zjy.job.carrental.enumerate.OrderStatusEnum;
import com.zjy.job.carrental.mapper.IOrderMapper;
import com.zjy.job.carrental.service.IOrderService;
import com.zjy.job.carrental.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单服务，场景复杂时可独立为一个微服务
 */
@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    IOrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
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
        orderMapper.insertSelective(order);
        BeanUtils.copyProperties(order,result);
        return result;
    }

    @Override
    public List<OrderVo> getOrdersByTimeSlot(Integer startTime, Integer endTime) {
        return null;
    }

}
