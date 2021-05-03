package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.domain.Car;
import com.zjy.job.carrental.domain.CarModel;
import com.zjy.job.carrental.mapper.ICarModelExtendMapper;
import com.zjy.job.carrental.mapper.ICarModelMapper;
import com.zjy.job.carrental.service.ICarModelService;
import com.zjy.job.carrental.vo.CarModelsQueryVo;
import com.zjy.job.carrental.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 车型管理服务
 */
@Service
public class CarModelService implements ICarModelService {
    @Autowired
    ICarModelMapper carModelMapper;

    @Autowired
    ICarModelExtendMapper carModelExtendMapper;

    @Override
    public List<CarModel> getCarModels(CarModelsQueryVo queryVo) {
        Example example = new Example(CarModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",queryVo.getType()).andLike("name","%"+queryVo.getModelName()+"%");
        List<CarModel> carModels = carModelMapper.selectByExample(example);
        return carModels;
    }

    @Override
    public CarModel getCarModelById(Integer carModelid) {
        return carModelMapper.selectByPrimaryKey(carModelid);
    }

}
