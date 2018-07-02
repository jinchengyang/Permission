package com.nepxion.permission.api.service;


import com.nepxion.permission.api.dto.PermissionResourcesDTO;
import com.nepxion.permission.api.model.Permission;

/**
 * 写服务接口
 *
 * @author jincy
 * @date 2018-06-25 16:09:10
 */
public interface PermissionWriteService {

    /**
     * 创建权限
     *
     * @param permission
     * @return Boolean
     */
    Boolean create(Permission permission);

    /**
     * 更新权限
     *
     * @param permission
     * @return Boolean
     */
    Boolean update(Long id, Permission permission);

    /**
     * 删除权限
     *
     * @param permissionId
     * @return Boolean
     */
    Boolean delete(Long tenantId, Long permissionId);

    /**
     * 权限绑定资源
     *
     * @param permissionResourcesDTO
     * @return
     */
    Boolean bindResources(PermissionResourcesDTO permissionResourcesDTO);

    /**
     * 权限解绑资源
     *
     * @param tenantId
     * @param permissionId
     * @return
     */
    Boolean unbindResources(Long tenantId, Long permissionId);

}