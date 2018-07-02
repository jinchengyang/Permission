/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package com.nepxion.permission.core.manager;

import com.nepxion.permission.api.dto.RolePermissionDTO;
import com.nepxion.permission.api.model.RolePermission;
import com.nepxion.permission.core.dao.RoleDao;
import com.nepxion.permission.core.dao.RolePermissionDao;
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
public class RoleManager {

    private final RoleDao roleDao;

    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RoleManager(RoleDao roleDao, RolePermissionDao rolePermissionDao) {
        this.roleDao = roleDao;
        this.rolePermissionDao = rolePermissionDao;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Long tenantId, Long roleId) {
        Example example = new Example(RolePermission.class);
        final Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        rolePermissionDao.deleteByExample(example);

        roleDao.deleteByPrimaryKey(roleId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean bindPermissions(RolePermissionDTO rolePermissionDTO) {
        List<RolePermission> listOld = rolePermissionDao.findByRoleId(rolePermissionDTO.getRoleId());
        if (listOld.size() > 0) {
            //先删后加
            Example example = new Example(RolePermission.class);
            final Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("roleId", rolePermissionDTO.getRoleId());
            rolePermissionDao.deleteByExample(example);
        }

        List<Long> permissionIds = rolePermissionDTO.getPermissionIds();
        List<RolePermission> list = new ArrayList<>();
        permissionIds.stream().forEach(id -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(rolePermissionDTO.getRoleId());
            rolePermission.setPermissionId(id);
            rolePermission.setIsDeleted(0);

            list.add(rolePermission);
        });

        int size = rolePermissionDao.creates(list);
        return size == list.size();
    }

}
