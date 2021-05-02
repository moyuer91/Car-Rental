package com.zjy.job.carrental.service;

import com.zjy.job.carrental.domain.CarModel;

import java.util.List;

public interface ICarService{
    /**
     *
     * @param types
     * @return
     */
    List<CarModel> getCarModels(List<String> types);

    CarModel getCarModelById(Integer id);
}