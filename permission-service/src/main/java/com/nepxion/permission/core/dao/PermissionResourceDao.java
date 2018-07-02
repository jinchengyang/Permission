package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.PermissionResource;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-25 16:11:28
 */
@Repository
public interface PermissionResourceDao extends Mapper<PermissionResource> {

    /**
     * 创建对象
     */
    Boolean create(PermissionResource permissionResource);

    int creates(List<PermissionResource> permissionResources);

    /**
     * 查询对象
     */
    PermissionResource findById(Long id);


    List<PermissionResource> findByPermissionId(Long permissionId);

    List<PermissionResource> findByResourceId(Long resourceId);

}
