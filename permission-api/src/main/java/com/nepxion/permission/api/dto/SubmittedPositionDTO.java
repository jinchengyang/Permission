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
@ApiModel(value = "SubmittedPositionDTO", description = "创建/编辑岗位所需信息")
public class SubmittedPositionDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty(notes = "岗位名称", required = true)
    private String name;

    @ApiModelProperty(notes = "岗位类型")
    private Integer type;

    /**
     * 其他信息
     */
    @ApiModelProperty("其他信息")
    private Map<String, String> extraMap;

    @JsonIgnore
    private String extraJson;
}
