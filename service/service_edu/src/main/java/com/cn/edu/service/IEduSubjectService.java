package com.cn.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.edu.entity.EduSubject;
import com.cn.edu.entity.extend.EduSubjectExt;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zjm
 * @since 2021-02-04
 */
public interface IEduSubjectService extends IService<EduSubject> {

    public void batchImport(MultipartFile file,IEduSubjectService eduSubjectService);

    public List<EduSubjectExt> qrySubjectTree();

}
