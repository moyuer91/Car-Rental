package com.zjy.job.carrental.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "jdbc")
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 车型id
     */
    private String modelId;

    /**
     * 车型图片url
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
