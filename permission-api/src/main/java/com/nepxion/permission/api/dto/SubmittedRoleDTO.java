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
@ApiModel(value = "SubmittedRoleDTO", description = "创建/编辑角色所需信息")
public class SubmittedRoleDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "角色名称", required = true)
    private String name;

    /**
     * 其他信息
     */
    @ApiModelProperty("其他信息")
    private Map<String, String> extraMap;

    @JsonIgnore
    private String extraJson;
}
