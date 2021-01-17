package com.cn.edu.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TeacherQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value =  "讲师名称,,模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String beginTime;

    @ApiModelProperty(value = "查询结束时间", example = "2019-01-01 10:10:10")
    private String endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
