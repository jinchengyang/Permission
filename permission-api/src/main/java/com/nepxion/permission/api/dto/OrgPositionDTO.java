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
@ApiModel(value = "OrgPositionDTO", description = "组织绑定岗位所需信息")
public class OrgPositionDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty("组织ID")
    private Long orgId;

    @ApiModelProperty(notes = "岗位ID")
    private List<Long> positionIds;

}
