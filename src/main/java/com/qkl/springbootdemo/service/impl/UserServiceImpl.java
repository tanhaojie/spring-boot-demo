package com.qkl.springbootdemo.service.impl;

import com.qkl.springbootdemo.mapper.UserMapper;
import com.qkl.springbootdemo.model.User;
import com.qkl.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


}
