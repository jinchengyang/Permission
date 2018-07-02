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
@ApiModel(value = "SubmittedPermissionDTO", description = "创建/编辑资源所需信息")
public class SubmittedResourceDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty("父资源ID")
    private Integer pid;

    @ApiModelProperty(notes = "资源名称", required = true)
    private String name;

    @ApiModelProperty("资源类型")
    private Integer type;

    @ApiModelProperty("资源在父资源中的排序")
    private Integer orderNo;

    @ApiModelProperty("资源URL")
    private String url;

    /**
     * 其他信息
     */
    @ApiModelProperty("其他信息")
    private Map<String, String> extraMap;

    @JsonIgnore
    private String extraJson;

}
