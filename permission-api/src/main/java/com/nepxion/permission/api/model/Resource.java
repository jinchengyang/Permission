package com.nepxion.permission.api.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jincy
 * @date 2018-06-25 16:10:45
 */
@Data
@Table(name = "resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = -4704160241067214164L;

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
     * 资源编码
     */
    private String code;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 父资源ID
     */
    private Long pid;

    /**
     * 资源在父资源中的排序
     */
    private Integer orderNo;

    /**
     * 资源URL
     */
    private String url;

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