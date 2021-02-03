package com.cn.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.edu.entity.SysDict;
import com.cn.edu.service.ISysDictService;
import com.cn.utils.basics.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjm
 * @since 2021-01-26
 */
@Api(description = "字典值管理")
@RestController
@RequestMapping("/eduservice/dict/")
//@CrossOrigin() //解决跨域注解
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    @ApiOperation(value = "根据传入的字典类型获取字典列表")
    @GetMapping(value="qryDictListByType/{type}")
    public Result qryDictListByType(
            @ApiParam(name = "type",value = "字典类型",required = true)
            @PathVariable String type){
        QueryWrapper<SysDict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("dict_type",type);
        List<SysDict> dictList = sysDictService.list(dictQueryWrapper);
        return Result.ok().data("dictList",dictList);
    }

}
