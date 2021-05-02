package com.zjy.job.carrental.controller;

import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.domain.Order;
import com.zjy.job.carrental.domain.PageRequest;
import com.zjy.job.carrental.domain.Result;
import com.zjy.job.carrental.service.ICarRentalService;
import com.zjy.job.carrental.common.annotation.SysLog;
import com.zjy.job.carrental.service.IStorageService;
import com.zjy.job.carrental.vo.OrderVo;
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
    private IStorageService carService;

    @GetMapping(value = "/car-models/{id}")
    @SysLog("get car model detail")
    public CarModel getPage(@PathVariable("id") Integer id){
        return carRentalService.getCarModelById(id);
    }


    @GetMapping(value = "/car-models")
    @SysLog("获取车型列表")
    public Result<List<CarModel>> getCarModels(PageRequest pageRequest){
        return new Result<>(carRentalService.getCarModels(null));
    }

    @GetMapping(value = "/reserve")
    @SysLog("预约车辆")
    public Result<OrderVo> reserve(OrderVo orderVo) throws ServiceException {
        return new Result<OrderVo>(carRentalService.reserveCar(orderVo));
    }
}
