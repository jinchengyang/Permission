package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.Permission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-25 16:09:10
 */
@Repository
public interface PermissionDao extends Mapper<Permission> {

    /**
     * 创建对象
     */
    Boolean create(Permission permission);

    /**
     * 更新对象
     */
    Boolean update(Permission permission);

    /**
     * 查询对象
     */
    Permission findById(Long id);

}
