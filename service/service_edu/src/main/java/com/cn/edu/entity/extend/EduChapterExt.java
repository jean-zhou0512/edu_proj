package com.cn.edu.entity.extend;

import com.cn.edu.entity.EduChapter;
import com.cn.edu.entity.model.MEduVideo;

import java.util.List;

public class EduChapterExt extends EduChapter {

    private List<MEduVideo> eduVideoList;

    public List<MEduVideo> getEduVideoList() {
        return eduVideoList;
    }

    public void setEduVideoList(List<MEduVideo> eduVideoList) {
        this.eduVideoList = eduVideoList;
    }
}
