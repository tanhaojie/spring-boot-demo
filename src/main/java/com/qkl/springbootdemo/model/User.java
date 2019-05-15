package com.qkl.springbootdemo.model;

import lombok.Data;

/**
 * @author tanhj
 */
@Data
public class User {

    private Integer userId;

    private String userName;

    private String password;

    private String phone;

}