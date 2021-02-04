package com.cn.edu.controller;


import com.cn.edu.entity.extend.EduSubjectExt;
import com.cn.edu.service.IEduSubjectService;
import com.cn.utils.basics.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zjm
 * @since 2021-02-04
 */
@Api(description="课程管理")
@RestController
@RequestMapping("/eduservice/subject/")
public class EduSubjectController {

    @Autowired
    private IEduSubjectService eduSubjectService;

    @ApiOperation(value = "excel导入课程")
    @PostMapping(value = "addSubject")
    public Result addSubject(
            @ApiParam(name = "file",value = "导入文件",required = true)
            MultipartFile file){
        eduSubjectService.batchImport(file,eduSubjectService);
        return Result.ok();
    }

    @ApiOperation(value = "获取课程分类树")
    @GetMapping(value = "subjectTree")
    public Result subjectTree(){
        List<EduSubjectExt> subjectTree = eduSubjectService.qrySubjectTree();
        return Result.ok().data("subjectTree",subjectTree);
    }

}
