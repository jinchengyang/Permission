package com.nepxion.permission.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jincy
 * @date 2018-06-25 15:45:19
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 7936544318830280043L;

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 岗位id
     */
    private Long positionId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 其他信息
     */
    private String extraJson;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 预留字段
     */
    private Integer options;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}