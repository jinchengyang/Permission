package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.RolePermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-25 16:10:00
 */
@Repository
public interface RolePermissionDao extends Mapper<RolePermission> {

    /**
     * 创建对象
     */
    Boolean create(RolePermission rolePermission);

    /**
     * 创建对象
     */
    int creates(List<RolePermission> rolePermissions);

    /**
     * 查询对象
     */
    RolePermission findById(Long id);

    /**
     * 根据权限id查询
     *
     * @param permissionId
     * @return
     */
    List<RolePermission> findByPermissionId(Long permissionId);

    /**
     * 根据角色id查询
     *
     * @param roleId
     * @return
     */
    List<RolePermission> findByRoleId(Long roleId);

}
