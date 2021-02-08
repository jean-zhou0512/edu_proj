package com.cn.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.edu.entity.EduChapter;
import com.cn.edu.entity.extend.EduChapterExt;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
public interface EduChapterMapper extends BaseMapper<EduChapter> {

    List<EduChapterExt> qryChapterByCourseId(String courseId);

}
