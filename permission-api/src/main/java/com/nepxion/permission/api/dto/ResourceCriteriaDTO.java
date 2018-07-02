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
@ApiModel(value = "ResourceCriteriaDTO", description = "资源查询条件")
public class ResourceCriteriaDTO extends PageCriteria implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty("父资源ID")
    private Integer pid;

    @ApiModelProperty(notes = "资源名称")
    private String name;

    @ApiModelProperty("资源编号")
    private String code;

    @ApiModelProperty("资源类型")
    private Integer type;

    @ApiModelProperty("资源URL")
    private String url;
}