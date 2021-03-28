package com.hanhang.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhang.mall.entity.UmsAdminRoleRelation;
import com.hanhang.mall.entity.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}