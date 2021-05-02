package com.zjy.job.carrental.vo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order")
public class OrderVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "jdbc")
    /**
     * 车型id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 车型id
     */
    private Integer modelId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 租用开始时间槽
     */
    private Integer startTime;

    /**
     * 租用结束时间槽
     */
    private Integer endTime;

    /**
     * 订单状态 P待支付 G待取车 R已取车 B已还车 C已取消
     */
    private String status;

}
