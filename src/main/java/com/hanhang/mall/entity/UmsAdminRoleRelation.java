package com.hanhang.mall.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ums_admin_role_relation
 * @author 
 */
@Data
public class UmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}