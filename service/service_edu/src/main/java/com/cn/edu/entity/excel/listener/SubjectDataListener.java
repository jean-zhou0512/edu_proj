package com.cn.edu.entity.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.edu.entity.EduSubject;
import com.cn.edu.entity.excel.SubjectData;
import com.cn.edu.service.IEduSubjectService;
import com.cn.servicebase.exception.CustomException;
import com.cn.utils.enums.ResultCodeEnum;
import org.apache.commons.lang3.StringUtils;

public class SubjectDataListener extends AnalysisEventListener<SubjectData> {

    private IEduSubjectService eduSubjectService;

    public SubjectDataListener(){};

    public SubjectDataListener(IEduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    /**
     * 读取每一行记录
     * @param subjectData
     * @param analysisContext
     */
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData == null){
            throw new CustomException(ResultCodeEnum.ERROR.getCode(),"文件不能为空");
        }

        if(subjectData.getOneSubjectName() == null || StringUtils.isBlank(subjectData.getOneSubjectName())){
            throw new CustomException(ResultCodeEnum.ERROR.getCode(),"导入的一级菜单不能为空");
        }

        if(subjectData.getTwoSubjectName() == null || StringUtils.isBlank(subjectData.getTwoSubjectName())){
            throw new CustomException(ResultCodeEnum.ERROR.getCode(),"导入的二级菜单不能为空");
        }
        EduSubject existSubject = isExistOneSubejct(subjectData.getOneSubjectName());

        EduSubject eduSubject = null;
        if(existSubject == null){
            eduSubject = new EduSubject();
            eduSubject.setParentId("0");
            eduSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(eduSubject);

            //二级课程
            EduSubject twoEduSubject = new EduSubject();
            twoEduSubject.setTitle(subjectData.getTwoSubjectName());
            twoEduSubject.setParentId(eduSubject.getId());
            eduSubjectService.save(twoEduSubject);
        }else{
            eduSubject = existSubject;

            EduSubject twoExistSubject = isExistTwoSubject(subjectData.getTwoSubjectName(),eduSubject.getId());
            if(twoExistSubject == null){
                //二级课程
                EduSubject twoEduSubject = new EduSubject();
                twoEduSubject.setTitle(subjectData.getTwoSubjectName());
                twoEduSubject.setParentId(eduSubject.getId());
                eduSubjectService.save(twoEduSubject);
            }
        }
    }

    /**
     * 判断是否已添加了一级课程
     *
     */
    public EduSubject isExistOneSubejct(String name){
        QueryWrapper<EduSubject> subjectQueryWrapper = new QueryWrapper<>();
        subjectQueryWrapper.eq("title",name)
                .eq("parent_id",0);

        EduSubject eduSubject = eduSubjectService.getOne(subjectQueryWrapper);
        return eduSubject;
    }

    /**
     * 判断是否已添加了2级课程
     */
    public EduSubject isExistTwoSubject(String name,String parentId){
        QueryWrapper<EduSubject> subjectQueryWrapper = new QueryWrapper<>();
        subjectQueryWrapper.eq("title",name)
                .eq("parent_id",parentId);
        EduSubject eduSubject = eduSubjectService.getOne(subjectQueryWrapper);

        return eduSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
