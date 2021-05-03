package com.zjy.job.carrental.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface IStorageCalenderExtendMapper {
    Boolean reduceStorageByTimeSlot(@Param("modelId")Integer modelId,@Param("startTime")Integer startTime, @Param("endTime")Integer endTime);
}
