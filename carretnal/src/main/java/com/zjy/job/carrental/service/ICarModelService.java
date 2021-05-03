package com.zjy.job.carrental.service;

import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.domain.PageRequest;
import com.zjy.job.carrental.vo.CarModelsQueryVo;
import com.zjy.job.carrental.vo.OrderVo;

import java.util.List;

public interface ICarModelService {

    /**
     * 根据页面表单创建订单
     * @param queryVo 查询条件
     * @return 符合条件的车型集合
     */
    List<CarModel> getCarModels(CarModelsQueryVo queryVo);


    /**
     * 根据车型id获取车型详情
     * @param carModelid 成型id
     * @return id对应的车型信息
     */
    CarModel getCarModelById(Integer carModelid);
}
