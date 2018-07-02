package com.nepxion.permission.core.service;

import com.google.common.base.Throwables;
import com.nepxion.permission.api.model.PermissionResource;
import com.nepxion.permission.api.model.Resource;
import com.nepxion.permission.api.service.ResourceWriteService;
import com.nepxion.permission.core.dao.PermissionResourceDao;
import com.nepxion.permission.core.dao.ResourceDao;
import com.nepxion.permission.utils.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 写服务实现类
 *
 * @author jincy
 * @date 2018-06-25 16:10:45
 */
@Slf4j
@Service
public class ResourceWriteServiceImpl implements ResourceWriteService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private PermissionResourceDao permissionResourceDao;

    @Override
    public Boolean create(Resource resource) {
        if (Objects.isNull(resource)) {
            log.error("resource.update.parameter.null");
            return false;
        }

        try {
            resource.setIsDeleted(0);
            Boolean success = resourceDao.create(resource);
            if (!success) {
                log.error("create resource fail, name: {}", resource.getName());
                return false;
            }
            String code = CodeGenerator.generatorCodeSerial(CodeGenerator.RESOURCE, resource.getId());
            resource.setCode(code);

            return resourceDao.update(resource);
        } catch (Exception e) {
            log.error("create resource fail, name: {}, cause:{}",
                    resource.getName(), Throwables.getStackTraceAsString(e));
            throw e;
        }

    }

    @Override
    public Boolean update(Long id, Resource resource) {
        if (Objects.isNull(id) || Objects.isNull(resource)) {
            log.error("resource.update.parameter.null");
            return false;
        }

        try {
            Resource positionOld = resourceDao.findById(id);
            if (Objects.isNull(positionOld)) {
                log.error("can't find resource, id: {}", id);
                return false;
            }
            positionOld.setName(resource.getName());
            positionOld.setType(resource.getType());
            positionOld.setUrl(resource.getUrl());
            return resourceDao.update(positionOld);
        } catch (Exception e) {
            log.error("update resource fail, id: {}, cause:{}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean delete(Long tenantId, Long resourceId) {
        if (Objects.isNull(resourceId)) {
            log.error("resource.delete.parameter.null");
            return false;
        }

        try {
            List<PermissionResource> permissionResourceList = permissionResourceDao.findByResourceId(resourceId);
            if (permissionResourceList.size() > 0) {
                log.error("resource already bind permission, can't be deleted, id:{}", resourceId);
                return false;
            }

            return resourceDao.deleteByPrimaryKey(resourceId) > 0;
        } catch (Exception e) {
            log.error("delete resource fail, id: {}, cause:{}", resourceId, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

}