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
        return Result.ok().data("name","zjm").data("avatar","https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E5%A4%B4%E5%83%8F&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=undefined&latest=undefined&copyright=undefined&cs=2142857875,120857813&os=1288745613,3110883842&simid=86412472,622890816&pn=9&rn=1&di=10920&ln=30&fr=&fmq=1390280702008_R&fm=&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&oriquery=%E5%A4%B4%E5%83%8F&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fc-ssl.duitang.com%252Fuploads%252Fitem%252F202005%252F12%252F20200512125346_RPeUw.thumb.400_0.jpeg%26refer%3Dhttp%253A%252F%252Fc-ssl.duitang.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1614165340%26t%3De9e9fd04955145f67058858dcafa83ce&rpstart=0&rpnum=0&adpicid=0&force=undefined");
    }

}
