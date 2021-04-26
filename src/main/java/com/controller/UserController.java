package com.controller;

import com.entity.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @program: test
 * @description
 * @author: wz
 * @create: 2021-04-07 11:21
 **/
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/select")
    public void getAll() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @GetMapping("/insert")
    public void insertOne() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString().substring(0, 1));
        user.setPassword(user.getName()+user.getName()+user.getName());
        user.setVersion(1);
        userMapper.insert(user);
    }
}
