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
@ApiModel(value = "UserPositionDTO", description = "用户和岗位绑定所需信息")
public class UserPositionDTO implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

    @ApiModelProperty(notes = "租户ID")
    private Long tenantId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty(notes = "岗位ID")
    private List<Long> positionIds;

}
