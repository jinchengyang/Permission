package com.nepxion.permission.core.service;

import com.google.common.base.Throwables;
import com.nepxion.permission.api.model.Resource;
import com.nepxion.permission.api.service.ResourceReadService;
import com.nepxion.permission.core.dao.ResourceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源读服务实现类
 *
 * @author jincy
 * @date 2018-06-25 16:10:45
 */
@Slf4j
@Service
public class ResourceReadServiceImpl implements ResourceReadService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public Resource findById(Long tenantId, Long id) {
        try {
            return resourceDao.findById(id);
        } catch (Exception e) {
            log.error("resource.find.fail, id: {}, cause:{}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public List<Resource> findByChildren(Long tenantId, Long pid) {
        try {
            return resourceDao.findByChildren(tenantId, pid);
        } catch (Exception e) {
            log.error("resource.find.children.fail, id: {}, cause:{}", pid, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public List<Resource> findAll(Long tenantId) {
        try {
            return resourceDao.selectAll();
        } catch (Exception e) {
            log.error("resource.find.all.fail, tenantId: {}, cause:{}", tenantId, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public List<Resource> findTopLevel(Long tenantId) {
        try {
            return resourceDao.findTopLevel(tenantId);
        } catch (Exception e) {
            log.error("resource.find.top.level.fail, tenantId: {}, cause:{}", tenantId, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

}
