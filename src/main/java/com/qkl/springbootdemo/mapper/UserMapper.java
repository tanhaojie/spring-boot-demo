package com.qkl.springbootdemo.mapper;

import com.qkl.springbootdemo.model.User;

/**
 * @author tanhj
 */
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}