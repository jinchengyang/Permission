package com.nepxion.permission.core.service;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Throwables;
import com.nepxion.permission.api.dto.PermissionCriteriaDTO;
import com.nepxion.permission.api.model.Permission;
import com.nepxion.permission.api.service.PermissionReadService;
import com.nepxion.permission.core.dao.PermissionDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * 读服务实现类
 *
 * @author jincy
 * @date 2018-06-25 16:09:10
 */
@Slf4j
@Service
public class PermissionReadServiceImpl implements PermissionReadService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission findById(Long tenantId, Long id) {
        try {
            return permissionDao.findById(id);
        } catch (Exception e) {
            log.error("permission.find.fail, id: {}, cause: {}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public List<Permission> paging(PermissionCriteriaDTO criteriaDTO) {
        try {
            PageHelper.startPage(criteriaDTO.getPageNo(), criteriaDTO.getPageSize());
            Example example = buildQueryExample(criteriaDTO);
            List<Permission> permissionList = permissionDao.selectByExample(example);
            return permissionList;
        } catch (Exception e) {
            log.error("permission.paging.fail, criteria: {}, cause:{}", criteriaDTO,
                    Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    private Example buildQueryExample(PermissionCriteriaDTO dto) {
        Example example = new Example(Permission.class);
        final Example.Criteria criteria = example.createCriteria();
        Optional.ofNullable(dto.getTenantId()).ifPresent(s->criteria.andEqualTo("tenantId", s));
        Optional.ofNullable(dto.getCode()).ifPresent(s->criteria.andEqualTo("code", s));
        Optional.ofNullable(dto.getName()).ifPresent(s -> {criteria.andLike("name", "%" + s + "%");});
        return example;
    }

}
