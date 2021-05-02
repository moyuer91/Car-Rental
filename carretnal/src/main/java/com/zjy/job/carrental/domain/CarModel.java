package com.zjy.job.carrental.domain;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "jdbc")
    /**
     * 车型id
     */
    private Integer id;

    /**
     * 车型名称
     */
    private String name;

    /**
     * 车辆品类
     */
    private String type;

    /**
     * 价格
     */
    private BigDecimal price;


    /**
     * 车型图片url
     */
    private String pictureUrl;

    /**
     * 车型详情
     */
    private String detail;

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
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

}

