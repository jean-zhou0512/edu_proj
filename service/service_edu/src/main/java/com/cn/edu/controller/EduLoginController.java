package com.cn.edu.controller;

import com.cn.utils.basics.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/user/")
@CrossOrigin //解决跨域注解
public class EduLoginController {

    @ApiOperation("简单登录接口，后面再改为使用spring security")
    @PostMapping(value="login")
    public Result login(){
        return Result.ok().data("token","admin");
    }

    @ApiOperation("简单返回用户信息接口，后面再进行修改")
    @GetMapping(value = "info")
    public Result info(){
        return Result.ok().data("name","zjm").data("avatar","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1091405991,859863778&fm=26&gp=0.jpg");
    }

}
