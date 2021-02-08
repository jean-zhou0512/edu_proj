package com.cn.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.edu.entity.EduChapter;
import com.cn.edu.entity.extend.EduChapterExt;
import com.cn.edu.mapper.EduChapterMapper;
import com.cn.edu.service.IEduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zjm
 * @since 2021-02-05
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements IEduChapterService {

    @Autowired
    private EduChapterMapper eduChapterMapper;
    @Override
    public List<EduChapterExt> qryChapterByCourseId(String courseId) {
        return eduChapterMapper.qryChapterByCourseId(courseId);
    }
}
