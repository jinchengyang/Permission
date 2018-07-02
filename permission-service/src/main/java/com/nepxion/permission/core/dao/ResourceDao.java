package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.Resource;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-25 16:10:45
 */
@Repository
public interface ResourceDao extends Mapper<Resource> {

    /**
     * 创建对象
     */
    Boolean create(Resource resource);

    /**
     * 更新对象
     */
    Boolean update(Resource resource);

    /**
     * 查询对象
     */
    Resource findById(Long id);

    List<Resource> findByChildren(Long tenantId, Long pid);

    List<Resource> findTopLevel(Long tenantId);

}
