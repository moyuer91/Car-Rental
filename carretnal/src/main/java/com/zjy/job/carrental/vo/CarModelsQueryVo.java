package com.zjy.job.carrental.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "车型查询vo")
public class CarModelsQueryVo {
    /**
     * 车辆品类
     */
    @ApiModelProperty(value="车辆品类")
    String type;

    /**
     * 车型名称
     */
    @ApiModelProperty(value="车型名称")
    String modelName;
}
