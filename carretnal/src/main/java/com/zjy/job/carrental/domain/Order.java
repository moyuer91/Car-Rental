package com.zjy.job.carrental.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order_info")
public class Order {

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
     * 车辆id，后续提车时录入
     */
    private Integer carId;

    /**
     * 成交价格
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

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 A生效，C失效
     */
    private String sts;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Integer updateUser;
}
