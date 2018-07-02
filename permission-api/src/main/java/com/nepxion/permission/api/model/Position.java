package com.nepxion.permission.api.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jincy
 * @date 2018-06-23 15:48:09
 */
@Data
@Table(name = "position")
public class Position implements Serializable {

    private static final long serialVersionUID = 2055094383721096747L;

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
     * 岗位编码
     */
    private String code;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位类型
     */
    private Integer type;

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