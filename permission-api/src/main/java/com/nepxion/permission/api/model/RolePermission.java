package com.nepxion.permission.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jincy
 * @date 2018-06-25 16:10:00
 */
@Data
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 780286938445925728L;

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;

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