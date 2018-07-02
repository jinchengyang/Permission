package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.OrgPosition;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-26 11:52:56
 */
@Repository
public interface OrgPositionDao extends Mapper<OrgPosition> {

    /**
     * 创建对象
     */
    Boolean create(OrgPosition orgPosition);

    /**
     * 创建对象
     */
    Integer creates(List<OrgPosition> orgPosition);

    /**
     * 根据组织id查询对象
     */
    List<OrgPosition> findByOrgId(Long orgId);

    /**
     * 根据岗位id查询对象
     */
    List<OrgPosition> findByPositionId(Long positionId);
}
