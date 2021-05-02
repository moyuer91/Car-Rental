package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.mapper.CarModelExtendMapper;
import com.zjy.job.carrental.mapper.CarModelMapper;
import com.zjy.job.carrental.service.ICarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarService implements ICarService {
    @Autowired
    private CarModelMapper carModelMapper;

    @Autowired
    private CarModelExtendMapper carModelExtendMapper;

    @Override
    public List<CarModel> getCarModels(List<String> types) {
        log.info("getCarModels params:",types);
        return carModelMapper.selectAll();
    }

    @Override
    public CarModel getCarModelById(Integer id) {
        log.info("getCarModelById params:",id);
        return carModelExtendMapper.selectByCondition1(id);
    }
}
