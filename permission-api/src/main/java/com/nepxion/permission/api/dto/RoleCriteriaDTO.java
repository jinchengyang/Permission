/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package com.nepxion.permission.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色支持的查询条件
 * Author:  jincy
 * Date: 2018-06-26
 */
@Data
@ApiModel(value = "RoleCriteriaDTO", description = "角色查询条件")
public class RoleCriteriaDTO extends PageCriteria implements Serializable {
    private static final long serialVersionUID = 2114364735901216606L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty("角色编号")
    private String code;

    @ApiModelProperty("角色名称")
    private String name;

}
