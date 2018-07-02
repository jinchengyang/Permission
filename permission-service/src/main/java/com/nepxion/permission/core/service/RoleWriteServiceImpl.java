package com.nepxion.permission.core.service;

import com.google.common.base.Throwables;
import com.nepxion.permission.api.dto.RolePermissionDTO;
import com.nepxion.permission.api.model.PositionRole;
import com.nepxion.permission.api.model.Role;
import com.nepxion.permission.api.service.RoleWriteService;
import com.nepxion.permission.core.dao.PositionRoleDao;
import com.nepxion.permission.core.dao.RoleDao;
import com.nepxion.permission.core.manager.RoleManager;
import com.nepxion.permission.utils.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 角色写服务实现类
 *
 * @author jincy
 * @date 2018-06-25 16:04:05
 */
@Slf4j
@Service
public class RoleWriteServiceImpl implements RoleWriteService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PositionRoleDao positionRoleDao;

    @Autowired
    private RoleManager roleManager;

    @Override
    public Boolean create(Role role) {
        if (Objects.isNull(role)) {
            log.error("role.create.parameter.null");
            return false;
        }

        try {
            role.setIsDeleted(0);
            Boolean success = roleDao.create(role);
            if (!success) {
                log.error("create role fail, name: {}", role.getName());
                return false;
            }
            String code = CodeGenerator.generatorCodeSerial(CodeGenerator.ROLE, role.getId());
            role.setCode(code);
            return roleDao.update(role);
        } catch (Exception e) {
            log.error("create role fail, name: {}, cause:{}",
                    role.getName(), Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean update(Long id, Role role) {
        if (Objects.isNull(id) || Objects.isNull(role)) {
            log.error("role.update.parameter.null");
            return false;
        }

        try {
            Role roleOld = roleDao.findById(id);
            if (Objects.isNull(roleOld)) {
                log.error("can't find role, id: {}", id);
                return false;
            }
            roleOld.setName(role.getName());
            return roleDao.update(roleOld);
        } catch (Exception e) {
            log.error("update role fail, id: {}, cause:{}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean delete(Long tenantId, Long roleId) {
        if (Objects.isNull(roleId)) {
            log.error("role.delete.parameter.null");
            return false;
        }

        List<PositionRole> positionRoles = positionRoleDao.findByRoleId(roleId);
        if (positionRoles.size() > 0) {
            log.error("role already bind position, can't be deleted, id:{}", roleId);
            return false;
        }

        try {
            roleManager.delete(tenantId, roleId);
            return true;
        } catch (Exception e) {
            log.error("delete role fail, id: {}, cause:{}", roleId, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean bindPermission(RolePermissionDTO rolePermissionDTO) {
        if (Objects.isNull(rolePermissionDTO)) {
            log.error("role.bind.parameter.null");
            return false;
        }

        return roleManager.bindPermissions(rolePermissionDTO);
    }

    @Override
    public Boolean unbindPermission(Long tenantId, Long roleId) {
        return null;
    }

}