package com.zjy.job.carrental.service.impl;

import com.zjy.job.carrental.domain.StorageTimeSlot;
import com.zjy.job.carrental.mapper.ICarMapper;
import com.zjy.job.carrental.mapper.IStorageCalenderMapper;
import com.zjy.job.carrental.service.IOrderService;
import com.zjy.job.carrental.service.IStorageService;
import com.zjy.job.carrental.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Slf4j
public class StorageService implements IStorageService {
    @Autowired
    private ICarMapper carMapper;

    @Autowired
    private IStorageCalenderMapper storageCalenderMapper;

    @Override
    public Boolean checkStorage(OrderVo order) {

        //1. 获取和本订单时间涉及的时间槽内的库存剩余为0的记录
        Example ex = new Example(StorageTimeSlot.class);
        Example.Criteria cr = ex.createCriteria();
        cr.andEqualTo("modelId",order.getModelId())
                .andBetween("timeSlotNo",order.getStartTime(),order.getEndTime())
                .andEqualTo("remaining",0);
        List<StorageTimeSlot> slots = storageCalenderMapper.selectByExample(ex);

        //2. 该时段的库存只要有一个不足就是库存不足
        if(CollectionUtils.isEmpty(slots)){
            return true;
        }
        return false;
    }

}
