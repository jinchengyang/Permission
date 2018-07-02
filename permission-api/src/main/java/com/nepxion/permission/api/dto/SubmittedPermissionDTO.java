package com.nepxion.permission.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author jincy
 * @time 2018/6/26
 */
@Data
@ApiModel(value = "SubmittedPermissionDTO", description = "创建/编辑权限所需信息")
public class SubmittedPermissionDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "权限名称", required = true)
    private String name;

    @ApiModelProperty("操作类型：ADD(新增), MODIFY(修改), DELETE(删除), QUERY(查询)")
    private String verb;

    /**
     * 其他信息
     */
    @ApiModelProperty("其他信息")
    private Map<String, String> extraMap;

    @JsonIgnore
    private String extraJson;
}
