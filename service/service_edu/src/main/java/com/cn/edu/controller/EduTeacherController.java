package com.cn.edu.controller;


import com.cn.edu.entity.EduTeacher;
import com.cn.edu.service.IEduTeacherService;
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
 * @since 2021-01-16
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/Teacher/")
public class EduTeacherController {
    @Autowired
    private IEduTeacherService eduTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping(value="qryAllTeacher")
    public List<EduTeacher> qryAllTeacher(){
        List<EduTeacher> eduTeacherList = eduTeacherService.list();
        return eduTeacherList;
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("deleteTeacher/{id}")
    public boolean deleteTeacher(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id){
        boolean result = eduTeacherService.removeById(id);
        return result;
    }

}
