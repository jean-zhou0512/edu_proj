package com.cn.utils.basics;

import com.cn.utils.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class Result {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<String, Object>();;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    private Result(){};

    public static Result ok(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setSuccess(true);
        result.setMessage(ResultCodeEnum.SUCCESS.getValue());
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.ERROR.getCode());
        result.setSuccess(false);
        result.setMessage(ResultCodeEnum.ERROR.getValue());
        return result;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key,Object value){
        this.getData().put(key,value);
        return this;
    }

    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
