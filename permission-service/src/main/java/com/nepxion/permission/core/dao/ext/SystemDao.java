package com.nepxion.permission.core.dao.ext;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author chenqi
 * @time 2017/8/3
 */
@Repository
public interface SystemDao {

    /**
     * 获取数据库时间
     * @return
     */
    Date querySysTime();
}
