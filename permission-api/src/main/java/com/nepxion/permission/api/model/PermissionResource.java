package com.nepxion.permission.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author [ your email ]
 * @date 2018-06-25 16:11:28
 * Created by CodeGen .
 */
@Data
public class PermissionResource implements Serializable {

    private static final long serialVersionUID = -462721959415852860L;

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 资源编码
     */
    private String resourceCode;

    /**
     * 资源id
     */
    private Long resourceId;

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