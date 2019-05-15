package com.qkl.springbootdemo.service;

import com.qkl.springbootdemo.model.User;

public interface UserService {

    int addUser(User user);

    User getUser(Integer userId);

}
