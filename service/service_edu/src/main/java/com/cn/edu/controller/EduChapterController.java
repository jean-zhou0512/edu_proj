package com.cn.edu.controller;


import com.cn.edu.entity.extend.EduChapterExt;
import com.cn.edu.service.IEduChapterService;
import com.cn.utils.basics.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
@Api(description = "课程章节管理")
@RestController
@RequestMapping("/eduservice/chapter/")
public class EduChapterController {

    @Autowired
    private IEduChapterService eduChapterService;

    @ApiOperation(value = "根据课程id查询课程章节信息")
    @GetMapping("/qryChapterByCourseId/{courseId}")
    public Result qryChapterByCourseId(
            @ApiParam(name = "courseId",value = "课程ID",required = true)
            @PathVariable String courseId){
        List<EduChapterExt> eduChapterList = eduChapterService.qryChapterByCourseId(courseId);
        return Result.ok().data("eduChapterList",eduChapterList);
    }




}
