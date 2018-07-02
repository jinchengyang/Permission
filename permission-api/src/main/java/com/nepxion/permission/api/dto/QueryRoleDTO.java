package com.nepxion.permission.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jincy
 * @time 2018/6/26
 */
@Data
@ApiModel(value = "QueryRoleDTO", description = "角色查询信息")
public class QueryRoleDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "角色ID")
    private Long id;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "角色名称")
    private String name;

    @ApiModelProperty("角色编号")
    private String code;

}
