package com.zjy.job.carrental.controller;

import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.domain.PageRequest;
import com.zjy.job.carrental.domain.Result;
import com.zjy.job.carrental.service.ICarRentalService;
import com.zjy.job.carrental.common.annotation.SysLog;
import com.zjy.job.carrental.service.ICarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rental")
@Api(value = "car rental interface")
public class CarRentalController {
    @Autowired
    private ICarRentalService carRentalService;

    @Autowired
    private ICarService carService;

    @GetMapping(value = "/car-models/{id}")
    @SysLog("get car model detail")
    public CarModel getPage(@PathVariable("id") Integer id){
        return carService.getCarModelById(id);
    }


    @GetMapping(value = "/car-models")
    @SysLog("获取车型列表")
    public Result<List<CarModel>> getCarModels(PageRequest pageRequest){
        return new Result<>(carService.getCarModels(null));
    }
}
