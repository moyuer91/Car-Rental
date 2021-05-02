package com.zjy.job.carrental.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 库存日历，以时间槽为单位
 */
@Data
@Table(name = "storage_calender")
public class StorageTimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "jdbc")
    /**
     * id
     */
    private Integer id;

    /**
     * 车型id
     */
    private Integer modelId;

    /**
     * 时间槽编号
     */
    private Integer timeSlotNo;

    /**
     * 最大可用数
     */
    private Integer maxAvailable;

    /**
     * 剩余可用数
     */
    private Integer remaining;

    /**
     * 时间槽编号
     */
    private Integer time_slot_no;
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
