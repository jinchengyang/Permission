/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package com.nepxion.permission.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询条件
 * Author:  jincy
 * Date: 2018-06-26
 */
@Data
public class PageCriteria implements Serializable {
    private static final long serialVersionUID = 2114364735901216606L;

    @ApiModelProperty("pageNo")
    protected int pageNo = 1;

    @ApiModelProperty("pageSize")
    protected int pageSize = 20;

    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量,低于1时自动调整为20.
     */
    public void setPageSize(final int pageSize) {
        if (pageSize > 100) {
            this.pageSize = 100;
            return;
        }
        if (pageSize <= 0) {
            this.pageSize = 20;
            return;
        }
        this.pageSize = pageSize;
    }
}
