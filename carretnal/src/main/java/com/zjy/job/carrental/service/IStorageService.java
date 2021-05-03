package com.zjy.job.carrental.service;

import com.zjy.job.carrental.vo.OrderVo;

public interface IStorageService {

    /**
     * 校验车辆库存
     * @param order 订单信息
     * @return true 库存>0 库存=0
     */
    Boolean checkStorage(OrderVo order);

    /**
     * 扣减库存
     * @param order
     * @return
     */
    Boolean reduceStorage(OrderVo order);
}