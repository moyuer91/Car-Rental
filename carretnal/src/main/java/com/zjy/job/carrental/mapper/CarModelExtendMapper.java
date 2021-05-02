package com.zjy.job.carrental.mapper;

import com.zjy.job.carrental.domain.CarModel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CarModelExtendMapper {
    CarModel selectByCondition1(Integer id);
}
