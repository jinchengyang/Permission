package com.nepxion.permission.core.dao;

import com.nepxion.permission.api.model.Position;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PositionDao extends Mapper<Position> {

    /**
     * 创建对象
     */
    Boolean create(Position position);

    /**
     * 更新对象
     */
    Boolean update(Position position);

    /**
     * 查询对象
     */
    Position findById(Long id);
}
