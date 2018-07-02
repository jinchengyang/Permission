package com.nepxion.permission.api.service;


import com.nepxion.permission.api.model.Resource;

/**
 * 写服务接口
 *
 * @author jincy
 * @date 2018-06-25 16:10:45
 */
public interface ResourceWriteService {

    /**
     * 创建资源
     *
     * @param resource
     * @return Boolean
     */
    Boolean create(Resource resource);

    /**
     * 更新资源
     *
     * @param resource
     * @return Boolean
     */
    Boolean update(Long id, Resource resource);

    /**
     * 删除资源
     *
     * @param resourceId
     * @return Boolean
     */
    Boolean delete(Long tenantId, Long resourceId);

}