package com.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mp.entity.Role;
import com.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @date: 2021/6/15
 * @auther: liu
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name = #{name}")
    public User findUserByName(String username);

    // 获取用户所拥有的角色
    @Select("select * from  role where rolecode in(select rolecode from userrole where username = #{userName})")
    public Set<Role> getUserRoles(String username);

}