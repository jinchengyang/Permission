package com.nepxion.permission.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author [ your email ]
 * @date 2018-06-26 11:52:56
 * Created by CodeGen .
 */
@Data
public class OrgPosition implements Serializable {

    private static final long serialVersionUID = 797448125178764767L;

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
     * 组织id
     */
    private Long orgId;

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