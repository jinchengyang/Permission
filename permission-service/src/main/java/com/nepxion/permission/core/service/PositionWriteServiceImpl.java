package com.nepxion.permission.core.service;

import com.google.common.base.Throwables;
import com.nepxion.permission.api.dto.OrgPositionDTO;
import com.nepxion.permission.api.dto.PositionRolesDTO;
import com.nepxion.permission.api.dto.UserPositionDTO;
import com.nepxion.permission.api.model.OrgPosition;
import com.nepxion.permission.api.model.Position;
import com.nepxion.permission.api.model.UserPosition;
import com.nepxion.permission.api.service.PositionWriteService;
import com.nepxion.permission.core.dao.OrgPositionDao;
import com.nepxion.permission.core.dao.PositionDao;
import com.nepxion.permission.core.dao.UserPositionDao;
import com.nepxion.permission.core.dao.ext.SystemDao;
import com.nepxion.permission.core.manager.PositionManager;
import com.nepxion.permission.utils.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 岗位写服务实现类
 *
 * @author jincy
 * @date 2018-06-23 15:48:09
 */
@Slf4j
@Service
public class PositionWriteServiceImpl implements PositionWriteService {

    @Autowired
    private SystemDao systemDao;

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private OrgPositionDao orgPositionDao;

    @Autowired
    private UserPositionDao userPositionDao;

    @Autowired
    private PositionManager positionManager;

    @Override
    public Boolean create(Position position) {
        if (Objects.isNull(position)) {
            log.error("position.create.parameter.invalid");
            return false;
        }

        try {
            position.setIsDeleted(0);
            Boolean success = positionDao.create(position);
            if (!success) {
                log.error("create position fail, name: {}", position.getName());
                return false;
            }
            String code = CodeGenerator.generatorCodeSerial(CodeGenerator.POSITION, position.getId());
            position.setCode(code);
            return positionDao.update(position);
        } catch (Exception e) {
            log.error("create position fail, name: {}, cause:{}", position.getName(), Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean update(Long id, Position position) {
        if (Objects.isNull(id) || Objects.isNull(position)) {
            log.error("position.update.parameter.null");
            return false;
        }

        try {
            Position positionOld = positionDao.findById(id);
            if (Objects.isNull(positionOld)) {
                log.error("can't find position, id: {}", id);
                return false;
            }
            positionOld.setName(position.getName());
            positionOld.setType(position.getType());
            return positionDao.update(positionOld);
        } catch (Exception e) {
            log.error("update position fail, id: {}, cause:{}", id, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean delete(Long tenantId, Long positionId) {
        if (Objects.isNull(positionId)) {
            log.error("position.delete.parameter.null");
            return false;
        }

        List<OrgPosition> orgPositions = orgPositionDao.findByPositionId(positionId);
        if (orgPositions.size() > 0) {
            log.error("position already bind org, can't be deleted, id:{}", positionId);
            return false;
        }

        List<UserPosition> userPositions = userPositionDao.findByPositionId(positionId);
        if (userPositions.size() > 0) {
            log.error("position already bind user, can't be deleted, id:{}", positionId);
            return false;
        }

        try {
            positionManager.delete(tenantId, positionId);
            return true;
        } catch (Exception e) {
            log.error("delete position fail, id: {}, cause:{}", positionId, Throwables.getStackTraceAsString(e));
            throw e;
        }
    }

    @Override
    public Boolean bindOrg(OrgPositionDTO orgPositionDTO) {
        if (Objects.isNull(orgPositionDTO)) {
            log.error("org.bind.position.parameter.null");
            return false;
        }
        return positionManager.bindOrg(orgPositionDTO);
    }

    @Override
    public Boolean unbindOrg(OrgPositionDTO orgPositionDTO) {
        return null;
    }

    @Override
    public Boolean bindUser(UserPositionDTO userPositionDTO) {
        if (Objects.isNull(userPositionDTO)) {
            log.error("user.bind.position.parameter.null");
            return false;
        }
        return positionManager.bindUser(userPositionDTO);
    }

    @Override
    public Boolean unbindUser(UserPositionDTO userPositionDTO) {
        return null;
    }

    @Override
    public Boolean bindRole(PositionRolesDTO positionRolesDTO) {
        if (Objects.isNull(positionRolesDTO)) {
            log.error("position.bind.user.parameter.null");
            return false;
        }
        return positionManager.bindRole(positionRolesDTO);
    }

    @Override
    public Boolean unbindRole(PositionRolesDTO positionRolesDTO) {
        return null;
    }

}