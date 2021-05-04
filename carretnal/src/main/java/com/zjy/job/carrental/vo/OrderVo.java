package com.zjy.job.carrental.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order")
@ApiModel( description = "订单vo")
public class OrderVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "jdbc")
    /**
     * 订单id
     */
    @ApiModelProperty(value="订单id")
    private Integer id;

    /**
     * 订单号
     */
    @ApiModelProperty(value="订单编号")
    private String orderNo;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id",required = true)
    private Integer userId;

    /**
     * 车型id
     */
    @ApiModelProperty(value="车型id",required = true)
    private Integer modelId;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格",required = true)
    private BigDecimal price;

    /**
     * 租用开始时间槽
     */
    @ApiModelProperty(value="租用开始时间槽",required = true)
    private Integer startTime;

    /**
     * 租用结束时间槽
     */
    @ApiModelProperty(value="租用结束时间槽",required = true)
    private Integer endTime;

    /**
     * 订单状态 P待支付 G待取车 R已取车 B已还车 C已取消
     */
    @ApiModelProperty(value="订单状态")
    private String status;

}
