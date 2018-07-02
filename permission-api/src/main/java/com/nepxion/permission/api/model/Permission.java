package com.nepxion.permission.api.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jincy
 * @date 2018-06-25 16:09:10
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = -1028837729671700344L;

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
     * 权限名称
     */
    private String name;

    /**
     * 权限编码
     */
    private String code;

    /**
     * ADD(新增), MODIFY(修改), DELETE(删除), QUERY(查询)
     */
    private String verb;

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