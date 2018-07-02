package com.nepxion.permission.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jincy
 * @time 2018/6/26
 */
@Data
@ApiModel(value = "RolePermissionDTO", description = "角色绑定权限所需信息")
public class RolePermissionDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "岗位ID")
    private Long roleId;

    @ApiModelProperty("权限ID列表")
    private List<Long> permissionIds;

}
