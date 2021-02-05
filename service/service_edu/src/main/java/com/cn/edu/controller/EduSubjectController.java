package com.cn.edu.controller;


import com.cn.edu.entity.extend.EduSubjectExt;
import com.cn.edu.service.IEduSubjectService;
import com.cn.utils.basics.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zjm
 * @since 2021-02-04
 */
@Api(description="课程分类管理")
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
    public Result subjectTree(
            @ApiParam(name = "title",value = "类别名称",required = false)
            @RequestParam(required = false) String title
    ){
        Map<String,Object> paramMap = new HashMap<>();
        if(title != null && StringUtils.isNotBlank(title)){
            paramMap.put("title",title);
        }else{
            paramMap.put("parentId",0);
        }
        List<EduSubjectExt> subjectTree = eduSubjectService.qrySubjectTree(paramMap);
        return Result.ok().data("subjectTree",subjectTree);
    }

}
