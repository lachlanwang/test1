package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.User;
import com.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * @program: test
 * @description
 * @author: wz
 * @create: 2021-04-07 15:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserController {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getAll() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testPage(){
        /**
         * 参数一：当前页
         * 参数二：页面大小
         */
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        //当前总页数
        System.out.println(page.getTotal());
    }

    @Test
    public void insertOne() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString().substring(0, 1));
        user.setPassword(user.getName()+user.getName()+user.getName());
        user.setVersion(1);
        userMapper.insert(user);
    }

    @Test
    public void updateOne() {
        QueryWrapper query = new QueryWrapper();
        query.eq("name","a");
        List<User> users = userMapper.selectList(query);
        users.get(0).setPassword(users.get(0).getPassword() + 1);
        userMapper.updateById(users.get(0));
    }

    @Test
    public void deleteOne() {
        userMapper.deleteById("610f5bf7-e49b-4621-8870-71d889d29beb");
    }
}
