package com.cn.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.edu.entity.EduChapter;
import com.cn.edu.entity.extend.EduChapterExt;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
public interface IEduChapterService extends IService<EduChapter> {

    List<EduChapterExt> qryChapterByCourseId(String courseId);

}
