/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package com.nepxion.permission.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 岗位支持的查询条件
 * Author:  jincy
 * Date: 2018-06-26
 */
@Data
public class PositionCriteriaDto implements Serializable {
    private static final long serialVersionUID = 2114364735901216606L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty("岗位编号")
    private String code;

    @ApiModelProperty("岗位名称")
    private String name;

    @ApiModelProperty("岗位类型")
    private Integer type;

    @ApiModelProperty("pageNo")
    private int pageNo;

    @ApiModelProperty("pageSize")
    private int pageSize;

}
