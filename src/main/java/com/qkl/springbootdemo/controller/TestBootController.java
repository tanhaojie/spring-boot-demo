package com.qkl.springbootdemo.controller;

import com.qkl.springbootdemo.model.User;
import com.qkl.springbootdemo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanhj
 */
@RestController
@RequestMapping("/testBoot")
public class TestBootController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户的信息",notes = "添加")
    @ApiImplicitParam(name ="userId",value = "用户id",paramType = "path",required = true,dataType = "String")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value="查询用户信息", notes="根据userId来查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    })
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public User queryUserById() {
        return userService.getUser(1000);
    }

}
