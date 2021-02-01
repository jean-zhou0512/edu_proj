package com.cn.oss.controller;

import com.cn.oss.service.OssService;
import com.cn.utils.basics.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(description = "oss文件上传")
@RestController
@RequestMapping(value = "/service/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传头像")
    @PostMapping("/uploadAvatar")
    public Result uploadAvatar(
            @ApiParam(name="file",value = "图片",required = true)
            MultipartFile file){
        String url = ossService.uploadAvatar(file);
        return Result.ok().data("url",url);
    }

}
