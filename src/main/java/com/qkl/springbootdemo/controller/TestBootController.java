package com.qkl.springbootdemo.controller;

import com.qkl.springbootdemo.model.User;
import com.qkl.springbootdemo.service.UserService;
import com.qkl.springbootdemo.utils.RandomUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    /*@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "D://img/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "上传失败！";
    }*/

    /*@PostMapping(value = "/upload")
    public String upload(HttpServletRequest request, @RequestParam("description") String description, @RequestParam("file") MultipartFile file) throws Exception {
        // 接收参数description
        System.out.println("description = " + description);
        // 如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String path = "D://img/";
            System.out.println("path = " + path);
            // 上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else {
            return "error";
        }
    }*/

    @RequestMapping(value = "/upload-head-img", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "头像上传接口")
    public String uploadImg(@RequestParam("editormd-image-file") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = multipartFile.getOriginalFilename();
        //设置允许上传文件类型
        String suffixList = "jpg,jpeg,png";
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (!suffixList.contains(suffix.trim().toLowerCase())) {
            return "图片格式不正确，当前支持的格式为：" + suffixList;
        }

        String filePath = "D://img/";
        File dest = new File(filePath + RandomUtil.getImgName() + "." + suffix);
        try {
            multipartFile.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "上传失败！";
    }

}
