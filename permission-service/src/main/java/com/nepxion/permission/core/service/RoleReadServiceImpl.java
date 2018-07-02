package com.nepxion.permission.core.service;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Throwables;
import com.nepxion.permission.api.dto.RoleCriteriaDTO;
import com.nepxion.permission.api.model.Role;
import com.nepxion.permission.api.service.RoleReadService;
import com.nepxion.permission.core.dao.RoleDao;
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
 * @date 2018-06-25 16:04:05
 */
@Slf4j
@Service
public class RoleReadServiceImpl implements RoleReadService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findById(Long tenantId, Long id) {
        try {
            return roleDao.findById(id);
        } catch (Exception e) {
            log.error("role.find.fail, id: {}, cause:{}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public List<Role> paging(RoleCriteriaDTO roleCriteriaDTO) {
        try {
            PageHelper.startPage(roleCriteriaDTO.getPageNo(), roleCriteriaDTO.getPageSize());
            Example example = buildQueryExample(roleCriteriaDTO);
            List<Role> roleList = roleDao.selectByExample(example);
            return roleList;
        } catch (Exception e) {
            log.error("role.paging.fail, criteria: {}, cause:{}", roleCriteriaDTO,
                    Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    private Example buildQueryExample(RoleCriteriaDTO dto) {
        Example example = new Example(Role.class);
        final Example.Criteria criteria = example.createCriteria();
        Optional.ofNullable(dto.getTenantId()).ifPresent(s->criteria.andEqualTo("tenantId", s));
        Optional.ofNullable(dto.getCode()).ifPresent(s->criteria.andEqualTo("code", s));
        Optional.ofNullable(dto.getName()).ifPresent(s -> {criteria.andLike("name", "%" + s + "%");});
        return example;
    }
}
