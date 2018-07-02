package com.nepxion.permission.api.service;

import com.nepxion.permission.api.dto.OrgPositionDTO;
import com.nepxion.permission.api.dto.PositionRolesDTO;
import com.nepxion.permission.api.dto.UserPositionDTO;
import com.nepxion.permission.api.model.Position;

/**
 * 岗位写服务接口
 *
 * @author jincy
 * @date 2018-06-23 15:48:09
 */
public interface PositionWriteService {

    /**
     * 创建岗位
     *
     * @param position
     * @return Boolean
     */
    Boolean create(Position position);

    /**
     * 更新岗位
     *
     * @param position
     * @return Boolean
     */
    Boolean update(Long id, Position position);

    /**
     * 删除岗位
     *
     * @param positionId
     * @return Boolean
     */
    Boolean delete(Long tenantId, Long positionId);

    /**
     * 组织绑定岗位
     *
     * @param orgPositionDTO
     * @return
     */
    Boolean bindOrg(OrgPositionDTO orgPositionDTO);

    /**
     * 组织解绑岗位
     *
     * @param orgPositionDTO
     * @return
     */
    Boolean unbindOrg(OrgPositionDTO orgPositionDTO);

    /**
     * 用户绑定岗位
     *
     * @param userPositionDTO
     * @return
     */
    Boolean bindUser(UserPositionDTO userPositionDTO);

    /**
     * 用户解绑岗位
     *
     * @param userPositionDTO
     * @return
     */
    Boolean unbindUser(UserPositionDTO userPositionDTO);

    /**
     * 岗位绑定角色
     *
     * @param positionRolesDTO
     * @return
     */
    Boolean bindRole(PositionRolesDTO positionRolesDTO);

    /**
     * 岗位解绑角色
     *
     * @param positionRolesDTO
     * @return
     */
    Boolean unbindRole(PositionRolesDTO positionRolesDTO);

}