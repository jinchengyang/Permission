package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.PositionRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-25 16:08:19
 */
@Repository
public interface PositionRoleDao extends Mapper<PositionRole> {

    /**
     * 创建对象
     */
    Boolean create(PositionRole positionRole);

    /**
     * 创建对象
     */
    Integer creates(List<PositionRole> positionRoles);

    /**
     * 根据岗位id查询对象
     */
    List<PositionRole> findByPositionId(Long positionId);

    /**
     * 根据角色id查询对象
     */
    List<PositionRole> findByRoleId(Long roleId);

}
