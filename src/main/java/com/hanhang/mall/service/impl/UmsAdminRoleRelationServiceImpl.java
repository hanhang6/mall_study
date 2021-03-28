package com.hanhang.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhang.mall.dao.UmsAdminRoleRelationMapper;
import com.hanhang.mall.entity.UmsAdminRoleRelation;
import com.hanhang.mall.entity.UmsPermission;
import com.hanhang.mall.service.UmsAdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationMapper, UmsAdminRoleRelation> implements UmsAdminRoleRelationService {
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationDao;

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }
}
