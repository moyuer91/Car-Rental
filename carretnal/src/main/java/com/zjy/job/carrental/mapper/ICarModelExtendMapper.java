package com.zjy.job.carrental.mapper;

import com.zjy.job.carrental.domain.CarModel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ICarModelExtendMapper {
    CarModel selectByCondition(Integer id);
}
