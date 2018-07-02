package com.nepxion.permission.api.service;

import com.nepxion.permission.api.model.Position;
import lombok.NonNull;

/**
 * 岗位读服务接口
 *
 * @author jincy
 * @date 2018-06-23 15:48:09
 */
public interface PositionReadService {

    /**
     * 通过主键查询
     *
     * @param id
     * @return position
     */
    Position findById(Long tenantId, @NonNull Long id);

    /**
     * 通过编号查询
     *
     * @param code
     * @return position
     */
    Position findByCode(Long tenantId, @NonNull String code);

}