package com.nepxion.permission.api.service;


import com.nepxion.permission.api.dto.RolePermissionDTO;
import com.nepxion.permission.api.model.Role;

/**
 * 角色写服务接口
 *
 * @author jincy
 * @date 2018-06-25 16:04:05
 */
public interface RoleWriteService {

    /**
     * 创建角色
     *
     * @param role
     * @return Boolean
     */
    Boolean create(Role role);

    /**
     * 更新角色
     *
     * @param id
     * @param role
     * @return
     */
    Boolean update(Long id, Role role);

    /**
     * 删除角色
     *
     * @param tenantId
     * @param roleId
     * @return
     */
    Boolean delete(Long tenantId, Long roleId);

    /**
     * 角色绑定权限
     *
     * @param rolePermissionDTO
     * @return
     */
    Boolean bindPermission(RolePermissionDTO rolePermissionDTO);

    /**
     * 角色解绑权限
     *
     * @param tenantId
     * @param roleId
     * @return
     */
    Boolean unbindPermission(Long tenantId, Long roleId);

}