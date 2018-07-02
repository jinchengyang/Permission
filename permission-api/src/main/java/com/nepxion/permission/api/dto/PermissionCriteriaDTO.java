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
@ApiModel(value = "PermissionCriteriaDTO", description = "权限查询条件")
public class PermissionCriteriaDTO extends PageCriteria implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "权限名称")
    private String name;

    @ApiModelProperty("权限编号")
    private String code;

}
