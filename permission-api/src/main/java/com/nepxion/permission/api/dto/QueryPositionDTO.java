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
@ApiModel(value = "QueryPositionDTO", description = "岗位查询信息")
public class QueryPositionDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "岗位ID")
    private Long id;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "岗位名称")
    private String name;

    @ApiModelProperty(notes = "岗位类型")
    private Integer type;

    @ApiModelProperty("岗位编号")
    private String code;

}
