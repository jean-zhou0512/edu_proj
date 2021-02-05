package com.cn.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.edu.entity.EduSubject;
import com.cn.edu.entity.extend.EduSubjectExt;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author zjm
 * @since 2021-02-04
 */
public interface EduSubjectMapper extends BaseMapper<EduSubject> {

    public List<EduSubjectExt> qrySubjectTree(Map<String,Object> paramMap);

}
