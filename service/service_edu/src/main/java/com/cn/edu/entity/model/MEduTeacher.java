package com.cn.edu.entity.model;

import com.cn.edu.entity.EduTeacher;

import java.io.Serializable;

public class MEduTeacher extends EduTeacher implements Serializable {
    private static final long serialVersionUID = 1L;

    private String levelName;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
