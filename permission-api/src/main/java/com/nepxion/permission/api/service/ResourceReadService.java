package com.nepxion.permission.api.service;


import com.nepxion.permission.api.model.Resource;

import java.util.List;

/**
 * 资源读服务实现类
 *
 * @author jincy
 * @date 2018-06-25 16:10:45
 */
public interface ResourceReadService {

    /**
     * 查询
     *
     * @param id
     * @return resource
     */
    Resource findById(Long tenantId, Long id);

    /**
     * 根据父id获取子资源列表
     *
     * @param tenantId
     * @param pid
     * @return
     */
    List<Resource> findByChildren(Long tenantId, Long pid);

    /**
     * 获取全部的资源列表
     *
     * @param tenantId
     * @return
     */
    List<Resource> findAll(Long tenantId);

    /**
     * 获取一级资源列表
     *
     * @param tenantId
     * @return
     */
    List<Resource> findTopLevel(Long tenantId);

}