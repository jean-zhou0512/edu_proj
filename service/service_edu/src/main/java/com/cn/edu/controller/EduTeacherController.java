package com.cn.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.edu.entity.EduTeacher;
import com.cn.edu.entity.vo.TeacherQuery;
import com.cn.edu.service.IEduTeacherService;
import com.cn.servicebase.exception.CustomException;
import com.cn.utils.basics.Result;
import com.cn.utils.enums.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/eduservice/teacher/")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private IEduTeacherService eduTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping(value="qryAllTeacher")
    public Result qryAllTeacher(){
        List<EduTeacher> eduTeacherList = eduTeacherService.list();
        return Result.ok().data("eduTeacherList",eduTeacherList);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("deleteTeacher/{id}")
    public Result deleteTeacher(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id){
        boolean result = eduTeacherService.removeById(id);
        return result?Result.ok():Result.error();
    }

    @ApiOperation(value = "分页查询讲师信息")
    @GetMapping(value = "qryTeacherByPage")
    public Result qryTeacherByPage(
            @ApiParam(name = "pageSize",value = "每页大小",required = true)
            @RequestParam int pageSize,
            @ApiParam(name = "currentPage",value = "当前页",required = true)
            @RequestParam int currentPage
    ){
        Page<EduTeacher> page = new Page<EduTeacher>(currentPage,pageSize);
        Page<EduTeacher> list = eduTeacherService.page(page);

        Map<String,Object> data = new HashMap<>();
        data.put("eduTeacherList",list.getRecords());
        data.put("total",list.getTotal());

        return Result
                .ok()
                .data("eduTeacherList",list.getRecords())
                .data("total",list.getTotal());
    }

    @ApiOperation("讲师分页查询，带查询条件")
    @PostMapping(value = "pageTeacherCondition/{currentPage}/{pageSize}")
    public Result pageTeacherCondition(
            @ApiParam(name = "currentPage",value = "当前页",required = true)
            @PathVariable int currentPage,
            @ApiParam(name = "pageSize",value = "每页大小",required = true)
            @PathVariable int pageSize,
            @ApiParam(name = "teacherQuery",value = "查询条件",required = false)
            @RequestBody(required = false) TeacherQuery teacherQuery
            ){
            Page<EduTeacher> pageTeacher = new Page<EduTeacher>();

            QueryWrapper<EduTeacher> teacherWrapper = new QueryWrapper<>();

            if(StringUtils.isNotBlank(teacherQuery.getName())){
                teacherWrapper.like("name",teacherQuery.getName());
            }

            if(teacherQuery.getLevel() != null && teacherQuery.getLevel() != 0){
                teacherWrapper.eq("level",teacherQuery.getLevel());
            }

            if (StringUtils.isNotBlank(teacherQuery.getBeginTime())){
                teacherWrapper.ge("gmt_create",teacherQuery.getBeginTime());
            }

            if(StringUtils.isNotBlank(teacherQuery.getEndTime())){
                teacherWrapper.le("gmt_create",teacherQuery.getEndTime());
            }
            Page<EduTeacher> page = eduTeacherService.page(pageTeacher, teacherWrapper);
            return Result
                    .ok()
                    .data("eduTeacherList",page.getRecords())
                    .data("total",page.getTotal());
    }

    @ApiOperation(value = "添加讲师")
    @PostMapping(value = "createTeacher")
    public Result createTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        return save?Result.ok():Result.error();
    }

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping(value = "qryTeacherById/{id}")
    public Result qryTeacherById(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id){
        try{
            int age = 10/0;
        }catch (Exception e){
            throw new CustomException(ResultCodeEnum.ERROR.getCode(),"自定义异常信息...");
        }
        EduTeacher teacher = eduTeacherService.getById(id);
        return Result.ok().data("teacher",teacher);
    }

    @ApiOperation(value = "修改讲师信息")
    @PostMapping(value = "updateTeacher")
    public Result updateTeacher(@RequestBody EduTeacher teacher){
        boolean result = eduTeacherService.updateById(teacher);
        return result?Result.ok():Result.error();
    }
}
