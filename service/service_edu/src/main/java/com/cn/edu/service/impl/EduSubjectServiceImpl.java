package com.cn.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.edu.entity.EduSubject;
import com.cn.edu.entity.excel.SubjectData;
import com.cn.edu.entity.excel.listener.SubjectDataListener;
import com.cn.edu.entity.extend.EduSubjectExt;
import com.cn.edu.mapper.EduSubjectMapper;
import com.cn.edu.service.IEduSubjectService;
import com.cn.servicebase.exception.CustomException;
import com.cn.utils.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author zjm
 * @since 2021-02-04
 */
@Service
@Slf4j
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements IEduSubjectService {

    @Autowired
    private EduSubjectMapper eduSubjectMapper;

    @Override
    public void batchImport(MultipartFile file,IEduSubjectService eduSubjectService) {
        try{

            EasyExcel.read(file.getInputStream(),SubjectData.class,new SubjectDataListener(eduSubjectService)).sheet().doRead();

        }catch (Exception e){
            log.error(e.getMessage());
            throw new CustomException(ResultCodeEnum.ERROR.getCode(),e.getMessage());
        }
    }

    @Override
    public List<EduSubjectExt> qrySubjectTree(Map<String,Object> paramMap) {
        return eduSubjectMapper.qrySubjectTree(paramMap);
    }
}
