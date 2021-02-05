package com.cn.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.edu.entity.EduCourse;
import com.cn.edu.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
public interface IEduCourseService extends IService<EduCourse> {

    public void addCourse(CourseInfoVo courseInfoVo);

}
