package com.cn.utils.enums;

public enum  CourseStatusEnum {
    UNPUBLISHED("未发布","Draft"),
    PUBLISHED("已发布","Normal");

    private String dict;
    private String value;

     CourseStatusEnum(String dict, String value) {
        this.dict = dict;
        this.value = value;
    }

    public String getDict() {
        return dict;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
