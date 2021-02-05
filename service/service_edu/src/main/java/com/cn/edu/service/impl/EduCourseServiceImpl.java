package com.cn.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.edu.entity.EduCourse;
import com.cn.edu.entity.EduCourseDescription;
import com.cn.edu.entity.vo.CourseInfoVo;
import com.cn.edu.mapper.EduCourseDescriptionMapper;
import com.cn.edu.mapper.EduCourseMapper;
import com.cn.edu.service.IEduCourseService;
import com.cn.utils.enums.CourseStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
@Service
@Transactional
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements IEduCourseService {

    @Autowired
    private EduCourseDescriptionMapper eduCourseDescriptionMapper;

    @Override
    public void addCourse(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        eduCourse.setBuyCount(0L);
        eduCourse.setViewCount(0L);
        eduCourse.setStatus(CourseStatusEnum.UNPUBLISHED.getValue());
        baseMapper.insert(eduCourse);

        EduCourseDescription description = new EduCourseDescription();

        description.setId(eduCourse.getId());
        description.setDescription(courseInfoVo.getDescription());
        eduCourseDescriptionMapper.insert(description);
    }
}
