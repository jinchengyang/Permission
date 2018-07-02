package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-25 16:04:05
 */
@Repository
public interface RoleDao extends Mapper<Role> {

    /**
     * 查询对象
     */
    Role findById(Long id);

    /**
     * 创建对象
     */
    Boolean create(Role role);

    /**
     * 更新对象
     */
    Boolean update(Role role);

}
