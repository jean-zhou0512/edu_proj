package com.cn.oss.controller;

import com.cn.oss.service.OssService;
import com.cn.utils.basics.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/service/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/uploadAvatar")
    public Result uploadAvatar(MultipartFile file){
        String url = ossService.uploadAvatar(file);
        return Result.ok().data("url",url);
    }

}
