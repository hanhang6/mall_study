package com.hanhang.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhang.mall.entity.UmsAdminRoleRelation;
import com.hanhang.mall.entity.UmsPermission;

import java.util.List;

public interface UmsAdminRoleRelationService extends IService<UmsAdminRoleRelation> {
    List<UmsPermission> getPermissionList(Long adminId);
}
