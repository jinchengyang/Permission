package com.nepxion.permission.core.service;

import com.google.common.base.Throwables;
import com.nepxion.permission.api.dto.PermissionResourcesDTO;
import com.nepxion.permission.api.model.Permission;
import com.nepxion.permission.api.model.RolePermission;
import com.nepxion.permission.api.service.PermissionWriteService;
import com.nepxion.permission.core.dao.PermissionDao;
import com.nepxion.permission.core.dao.RolePermissionDao;
import com.nepxion.permission.core.manager.PermissionManager;
import com.nepxion.permission.utils.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 权限写服务实现类
 *
 * @author jincy
 * @date 2018-06-25 16:09:10
 */
@Slf4j
@Service
public class PermissionWriteServiceImpl implements PermissionWriteService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private PermissionManager permissionManager;

    @Override
    public Boolean create(Permission permission) {
        if (Objects.isNull(permission)) {
            log.error("permission.create.parameter.null");
            return false;
        }

        try {
            permission.setIsDeleted(0);
            Boolean success = permissionDao.create(permission);
            if (!success) {
                log.error("create permission fail, name: {}", permission.getName());
                return false;
            }
            String code = CodeGenerator.generatorCodeSerial(CodeGenerator.PERMISSION, permission.getId());
            permission.setCode(code);
            return permissionDao.update(permission);
        } catch (Exception e) {
            log.error("create permission fail, name: {}, cause:{}",
                    permission.getName(), Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean update(Long id, Permission permission) {
        if (Objects.isNull(id) || Objects.isNull(permission)) {
            log.error("permission.update.parameter.null");
            return false;
        }

        try {
            Permission positionOld = permissionDao.findById(id);
            if (Objects.isNull(positionOld)) {
                log.error("can't find permission, id: {}", id);
                return false;
            }
            positionOld.setName(permission.getName());
            positionOld.setVerb(permission.getVerb());
            return permissionDao.update(positionOld);
        } catch (Exception e) {
            log.error("update permission fail, id: {}, cause:{}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean delete(Long tenantId, Long permissionId) {
        if (Objects.isNull(permissionId)) {
            log.error("permission.delete.parameter.null");
            return false;
        }

        List<RolePermission> rolePermissionList = rolePermissionDao.findByPermissionId(permissionId);
        if (rolePermissionList.size() > 0) {
            log.error("permission already bind role, can't be deleted, id:{}", permissionId);
            return false;
        }

        try {
            permissionManager.delete(tenantId, permissionId);
            return true;
        } catch (Exception e) {
            log.error("delete permission fail, id: {}, cause:{}", permissionId, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean bindResources(PermissionResourcesDTO permissionResourcesDTO) {
        if (Objects.isNull(permissionResourcesDTO)) {
            log.error("permission.bind.parameter.null");
            return false;
        }

        return permissionManager.bindResources(permissionResourcesDTO);
    }

    @Override
    public Boolean unbindResources(Long tenantId, Long permissionId) {
        return null;
    }

}