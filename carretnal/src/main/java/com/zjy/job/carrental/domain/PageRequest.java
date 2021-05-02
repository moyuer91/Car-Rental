package com.zjy.job.carrental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页 默认为1")
    private int pageNum=1;

    @ApiModelProperty(value = "每页大小 默认为10")
    private int pageSize=10;

    @ApiModelProperty(value = "排序字段")
    private String orderBy;

    public PageRequest() {
        super();
    }
}