/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package com.nepxion.permission.core.manager;

import com.nepxion.permission.api.dto.OrgPositionDTO;
import com.nepxion.permission.api.dto.PositionRolesDTO;
import com.nepxion.permission.api.dto.UserPositionDTO;
import com.nepxion.permission.api.model.OrgPosition;
import com.nepxion.permission.api.model.PositionRole;
import com.nepxion.permission.api.model.UserPosition;
import com.nepxion.permission.core.dao.OrgPositionDao;
import com.nepxion.permission.core.dao.PositionDao;
import com.nepxion.permission.core.dao.PositionRoleDao;
import com.nepxion.permission.core.dao.UserPositionDao;
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
public class PositionManager {

    private final PositionDao positionDao;

    private final PositionRoleDao positionRoleDao;

    private final UserPositionDao userPositionDao;

    private final OrgPositionDao orgPositionDao;

    @Autowired
    public PositionManager(PositionDao positionDao,
                           PositionRoleDao positionRoleDao,
                           UserPositionDao userPositionDao,
                           OrgPositionDao orgPositionDao) {
        this.positionDao = positionDao;
        this.positionRoleDao = positionRoleDao;
        this.userPositionDao = userPositionDao;
        this.orgPositionDao = orgPositionDao;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Long tenantId, Long positionId) {
        Example example = new Example(PositionRole.class);
        final Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("positionId", positionId);
        positionRoleDao.deleteByExample(example);

        positionDao.deleteByPrimaryKey(positionId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean bindOrg(OrgPositionDTO orgPositionDTO) {
        List<OrgPosition> orgPositionList = orgPositionDao.findByOrgId(orgPositionDTO.getOrgId());
        if (orgPositionList.size() > 0) {
            //先删后加
            Example example = new Example(OrgPosition.class);
            final Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("orgId", orgPositionDTO.getOrgId());
            orgPositionDao.deleteByExample(example);
        }

        List<Long> positionIds = orgPositionDTO.getPositionIds();
        List<OrgPosition> list = new ArrayList<>();
        positionIds.stream().forEach(id -> {
            OrgPosition orgPosition = new OrgPosition();
            orgPosition.setOrgId(orgPositionDTO.getOrgId());
            orgPosition.setPositionId(id);
            orgPosition.setIsDeleted(0);

            list.add(orgPosition);
        });

        return orgPositionDao.creates(list) == list.size();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean bindUser(UserPositionDTO userPositionDTO) {
        List<UserPosition> userPositionList = userPositionDao.findByUserId(userPositionDTO.getUserId());
        if (userPositionList.size() > 0) {
            //先删后加
            Example example = new Example(UserPosition.class);
            final Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", userPositionDTO.getUserId());
            userPositionDao.deleteByExample(example);
        }

        List<Long> positionIds = userPositionDTO.getPositionIds();
        List<UserPosition> list = new ArrayList<>();
        positionIds.stream().forEach(id -> {
            UserPosition userPosition = new UserPosition();
            userPosition.setUserId(userPositionDTO.getUserId());
            userPosition.setPositionId(id);
            userPosition.setIsDeleted(0);

            list.add(userPosition);
        });

        return userPositionDao.creates(list) == list.size();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean bindRole(PositionRolesDTO positionRolesDTO) {
        List<PositionRole> positionRoleList = positionRoleDao.findByPositionId(positionRolesDTO.getPositionId());
        if (positionRoleList.size() > 0) {
            //先删后加
            Example example = new Example(PositionRole.class);
            final Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("positionId", positionRolesDTO.getPositionId());
            positionRoleDao.deleteByExample(example);
        }

        List<Long> roleIds = positionRolesDTO.getRoleIds();
        List<PositionRole> list = new ArrayList<>();
        roleIds.stream().forEach(id -> {
            PositionRole positionRole = new PositionRole();
            positionRole.setPositionId(positionRolesDTO.getPositionId());
            positionRole.setRoleId(id);
            positionRole.setIsDeleted(0);

            list.add(positionRole);
        });

        return positionRoleDao.creates(list) == list.size();
    }

}
