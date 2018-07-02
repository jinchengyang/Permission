package com.nepxion.permission.api.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author [ your email ]
 * @date 2018-06-25 16:04:05
 * Created by CodeGen .
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -8402288326790729001L;

    /**
     * 自增主键
     */
    @Id
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 其他信息
     */
    private String extraJson;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 最后更新人
     */
    private Long updatedBy;

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