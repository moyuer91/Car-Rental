package com.zjy.job.carrental.domain;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;

    @ApiModelProperty(value="返回信息")
    private String msg = "success";

    @ApiModelProperty(value="错误码 0表示成功")
    private int errno = SUCCESS;

    @ApiModelProperty(value="成功标志 true为成功")
    private Boolean success = true;

    @ApiModelProperty(value="session建立标志 true为成功")
    private Boolean session = true;

    @ApiModelProperty(value="页数")
    private int pageNum;

    @ApiModelProperty(value="单页条数")
    private int pageSize;

    @ApiModelProperty(value="总条数")
    private long total;

    @ApiModelProperty(value="总页面数")
    private int totalPage;

    @ApiModelProperty(value="数据体")
    private T data;

    public Result() {
        super();
    }

    public Result(T data) {
        super();
        this.data = data;
    }


    public Result(PageInfo data) {
        super();
        this.pageNum = ((PageInfo) data).getPageNum();
        this.pageSize = ((PageInfo) data).getPageSize();
        this.total = ((PageInfo) data).getTotal();
        this.totalPage = ((PageInfo) data).getPages();
        this.data = (T)((PageInfo) data).getList();
    }
    public Result(Throwable e) {
        super();
        this.msg = e.toString();
        this.errno= FAIL ;
    }
}