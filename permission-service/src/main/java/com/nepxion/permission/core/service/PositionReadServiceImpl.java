package com.nepxion.permission.core.service;

import com.nepxion.permission.api.model.Position;
import com.nepxion.permission.api.service.PositionReadService;
import com.nepxion.permission.core.dao.PositionDao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 读服务实现类
 *
 * @author jincy
 * @date 2018-06-23 15:48:09
 */
@Service
public class PositionReadServiceImpl implements PositionReadService {

    @Autowired
    private PositionDao positionDao;

    /**
     * 根据id查找
     * @param id 岗位id
     * @return 唯一参数对象
     */
    public Position findById(Long tenantId, @NonNull Long id){
        return positionDao.selectByPrimaryKey(id);
    }

    /**
     * 通过编号查询
     *
     * @param code
     * @return position
     */
    public Position findByCode(Long tenantId, @NonNull String code) {
        return null;
    }

}
