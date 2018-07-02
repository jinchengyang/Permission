package com.nepxion.permission.api.service;

import com.nepxion.permission.api.dto.RoleCriteriaDTO;
import com.nepxion.permission.api.model.Role;

import java.util.List;

/**
 * 读服务接口
 *
 * @author jincy
 * @date 2018-06-25 16:04:05
 */
public interface RoleReadService {

    /**
     * 查询
     *
     * @param tenantId
     * @param id
     * @return role
     */
    Role findById(Long tenantId, Long id);


    /**
     * 分页查询权限
     *
     * @return
     */
    List<Role> paging(RoleCriteriaDTO roleCriteriaDTO);

}