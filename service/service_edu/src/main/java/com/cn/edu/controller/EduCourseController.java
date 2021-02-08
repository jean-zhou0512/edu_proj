package com.cn.edu.controller;


import com.cn.edu.entity.EduCourse;
import com.cn.edu.entity.EduCourseDescription;
import com.cn.edu.entity.extend.EduChapterExt;
import com.cn.edu.entity.vo.CourseInfoVo;
import com.cn.edu.service.IEduChapterService;
import com.cn.edu.service.IEduCourseDescriptionService;
import com.cn.edu.service.IEduCourseService;
import com.cn.utils.basics.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
@Api(description = "课程管理")
@RestController
@RequestMapping("/eduservice/course/")
public class EduCourseController {

    @Autowired
    private IEduCourseService eduCourseService;

    @Autowired
    private IEduChapterService eduChapterService;

    @Autowired
    private IEduCourseDescriptionService eduCourseDescriptionService;

    @PostMapping(value = "addCourse")
    public Result addCourse(
            @ApiParam(name = "courseInfoVo",value = "课程信息",required = true)
            @RequestBody CourseInfoVo courseInfoVo
            ){

        if(courseInfoVo == null ){
            return Result.error().message("课程信息不能为空");
        }

        if(courseInfoVo.getTeacherId() == null || StringUtils.isBlank(courseInfoVo.getTeacherId())){
            return Result.error().message("讲师ID不能为空");
        }

        if(courseInfoVo.getSubjectId() == null || StringUtils.isBlank(courseInfoVo.getSubjectId())){
            return Result.error().message("课程专业ID不能为空");
        }

        if(courseInfoVo.getSubjectParentId() == null || StringUtils.isBlank(courseInfoVo.getSubjectParentId())){
            return Result.error().message("课程专业父级ID不能为空");
        }

        if(courseInfoVo.getTitle() == null || StringUtils.isBlank(courseInfoVo.getTitle())){
            return Result.error().message("课程标题不能为空");
        }

        if(courseInfoVo.getPrice() == null ){
            return Result.error().message("课程销售价格不能为空");
        }

        if(courseInfoVo.getLessonNum() == null ){
            return Result.error().message("课程总课时不能为空");
        }

        if(courseInfoVo.getCover() == null|| StringUtils.isBlank(courseInfoVo.getCover())){
            return Result.error().message("课程封面图片不能为空");
        }

        if(courseInfoVo.getDescription() == null|| StringUtils.isBlank(courseInfoVo.getDescription())){
            return Result.error().message("课程简介不能为空");
        }

        eduCourseService.addCourse(courseInfoVo);
        return Result.ok();
    }

    @ApiOperation(value = "根据课程ID查询课程所有信息")
    @GetMapping("qryCourseInfo/{courseId}")
    public Result qryCourseInfo(
            @ApiParam(value = "课程ID",name = "courseId",required = true)
            @PathVariable String courseId){
        EduCourse eduCourse = eduCourseService.getById(courseId);
        EduCourseDescription eduCourseDescription = eduCourseDescriptionService.getById(courseId);
        List<EduChapterExt> eduChapterList = eduChapterService.qryChapterByCourseId(courseId);
        return Result.ok().data("eduCourse",eduCourse).data("eduCourseDescription",eduCourseDescription).data("eduChapterList",eduChapterList);
    }
}
