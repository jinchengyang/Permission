/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package com.nepxion.permission.core.manager;

import com.nepxion.permission.api.dto.PermissionResourcesDTO;
import com.nepxion.permission.api.model.PermissionResource;
import com.nepxion.permission.core.dao.PermissionDao;
import com.nepxion.permission.core.dao.PermissionResourceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jincy
 * Date: 2018-06-26
 */
@Slf4j
@Component
public class PermissionManager {

    private final PermissionDao permissionDao;

    private final PermissionResourceDao permissionResourceDao;

    @Autowired
    public PermissionManager(PermissionDao permissionDao, PermissionResourceDao permissionResourceDao) {
        this.permissionDao = permissionDao;
        this.permissionResourceDao = permissionResourceDao;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Long tenantId, Long permissionId) {
        Example example = new Example(PermissionResource.class);
        final Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("permissionId", permissionId);
        Integer size = permissionResourceDao.deleteByExample(example);

        permissionDao.deleteByPrimaryKey(permissionId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean bindResources(PermissionResourcesDTO permissionResourcesDTO) {

        List<PermissionResource> listOld = permissionResourceDao.findByPermissionId(permissionResourcesDTO.getPermissionId());
        if (listOld.size() > 0) {
            //先删后加
            Example example = new Example(PermissionResource.class);
            final Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("permissionId", permissionResourcesDTO.getPermissionId());
            permissionResourceDao.deleteByExample(example);
        }

        List<Long> resourcesIds = permissionResourcesDTO.getResourcesIds();
        List<PermissionResource> list = new ArrayList<>();
        resourcesIds.stream().forEach(id -> {
            PermissionResource permissionResource = new PermissionResource();
            permissionResource.setPermissionId(permissionResourcesDTO.getPermissionId());
            permissionResource.setResourceId(id);
            permissionResource.setIsDeleted(0);

            list.add(permissionResource);
        });

        return permissionResourceDao.creates(list) == list.size();
    }

}
