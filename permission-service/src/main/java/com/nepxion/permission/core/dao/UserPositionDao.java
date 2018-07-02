package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.UserPosition;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * DAO层
 *
 * @author jincy
 * @date 2018-06-26 09:59:48
 */
@Repository
public interface UserPositionDao extends Mapper<UserPosition> {

    /**
     * 创建对象
     */
    Boolean create(UserPosition userPosition);

    /**
     * 创建对象
     */
    Integer creates(List<UserPosition> userPositions);

    /**
     * 根据用户id查询对象
     */
    List<UserPosition> findByUserId(Long userId);


    /**
     * 根据岗位id查询对象
     */
    List<UserPosition> findByPositionId(Long userId);

}
