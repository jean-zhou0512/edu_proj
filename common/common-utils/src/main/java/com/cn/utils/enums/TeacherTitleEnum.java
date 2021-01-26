package com.cn.utils.enums;

public enum TeacherTitleEnum {
    A_SENIOR_LECTURER("高级讲师",1),
    CHIEF_LECTURER("首席讲师",2);

    private String dict;
    private int value;

    public static String dictType = "teacher_title";

    TeacherTitleEnum(String dict, int value) {
        this.dict = dict;
        this.value = value;
    }

    public String getDict() {
        return dict;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
}
