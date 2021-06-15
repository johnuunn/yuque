package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.entity.Role;
import com.mp.entity.User;
import com.mp.mapper.RoleMapper;
import com.mp.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

/**
 * 保持和main 目录一致
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {

        // 此处 null 指的是不用根据参数去查询
        // 可以调用 CRUD 相关的多种方式

        // 1. 查询所有的数据
        List<User> userList = userMapper.selectList(null);
        userList.forEach(user -> System.out.println(user.getName()));

        // 2. 根据 id 删除
        userMapper.deleteById(1);

        // 3. 添加数据
        User user = new User();
        user.setName("老王");
        user.setEmail("laowang@test.com");
        user.setAge(18);
        userMapper.insert(user);

        // 4. 更新数据
        user.setName("老王王");
        user.setEmail("laowangwang@test.com");
        userMapper.updateById(user);
    }


    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testUserRole() {

        User user = userMapper.findUserByName("cuihua");
        Set<Role> roles = userMapper.getUserRoles("cuihua");

        for (Role role : roles) {
            role.setPermissions(roleMapper.
                    getRolePermissions(role.getRoleCode()));
        }

        user.setRoles(roles);
        System.out.println(user);
    }

    @Test
    public void testSelect2(){
        IPage<User> page = selectUserPage();
        List<User> userList = page.getRecords();
        userList.forEach(user -> System.out.println("用户：" + user));
    }

    // 查询年龄在 20-30 名字为 cuihua 的用户
    public  IPage<User>  selectUserPage() {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        Page page = new Page<User>(1, 20);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().between("age", 18, 20).eq("name", "cuihua");
        return userMapper.selectPage(page, queryWrapper);
    }

}