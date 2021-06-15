package com.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mp.entity.Permission;
import com.mp.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

public interface RoleMapper extends BaseMapper<User> {

    // 获取角色所拥有权限
    @Select("select * from permission where permissioncode in (select permissioncode from rolepermission where rolecode = #{roleCode})")
    public Set<Permission> getRolePermissions(String roleCode);

}