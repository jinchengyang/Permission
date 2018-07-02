package com.nepxion.permission.api.service;


import com.nepxion.permission.api.dto.PermissionCriteriaDTO;
import com.nepxion.permission.api.model.Permission;

import java.util.List;

/**
 * 读服务接口
 *
 * @author [ your email ]
 * @date 2018-06-25 16:09:10
 * Created by CodeGen .
 */
public interface PermissionReadService {

    /**
     * 查询
     *
     * @param id
     * @return permission
     */
    Permission findById(Long tenantId, Long id);

    /**
     * 分页查询权限
     *
     * @param criteriaDTO
     * @return
     */
    List<Permission> paging(PermissionCriteriaDTO criteriaDTO);

}