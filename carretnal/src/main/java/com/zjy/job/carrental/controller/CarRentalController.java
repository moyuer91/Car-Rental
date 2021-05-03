package com.zjy.job.carrental.controller;

import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.domain.PageRequest;
import com.zjy.job.carrental.domain.Result;
import com.zjy.job.carrental.service.ICarModelService;
import com.zjy.job.carrental.service.ICarRentalService;
import com.zjy.job.carrental.common.annotation.SysLog;
import com.zjy.job.carrental.service.IStorageService;
import com.zjy.job.carrental.vo.CarModelsQueryVo;
import com.zjy.job.carrental.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    ICarModelService carModelService;

    @Autowired
    private IStorageService carService;

    @GetMapping(value = "/car-models/{id}")
    @SysLog("get car model detail")
    @ApiOperation(value="根据车型id获取车型详细数据", notes="根据车型id获取车型详细数据")
    public CarModel getCarModelById(@PathVariable("id") @ApiParam(value="车型id",required=true)Integer id){
        return carModelService.getCarModelById(id);
    }


    @GetMapping(value = "/car-models")
    @ApiOperation(value="获取车型列表", notes="获取车型列表")
    @SysLog("获取车型列表")
    public Result<List<CarModel>> getCarModels(CarModelsQueryVo queryVo){
        return new Result<>(carModelService.getCarModels(queryVo));
    }

    @PostMapping(value = "/reserve")
    @ApiOperation(value="预约车辆下单", notes="预约车辆下单")
    @SysLog("预约车辆")
    public Result<OrderVo> reserve(@RequestBody OrderVo orderVo) throws ServiceException {
        return new Result<OrderVo>(carRentalService.reserveCarWithReentrantLock(orderVo));
    }
}
