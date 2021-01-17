package com.cn.servicebase.exception;

import io.swagger.annotations.ApiModelProperty;

/**
 * 自定义异常类
 *
 * 标记类时swagger的解析类
 * @ApiModelProperty()用于方法，字段； 使用在被 @ApiModel 注解的模型类的属性上
 * value–字段说明
 * name–重写属性名字
 * dataType–重写属性类型
 * required–是否必填
 * example–举例说明
 * hidden–隐藏
 */
public class CustomException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "异常信息")
    private String msg;

    public CustomException() {
    }

    public CustomException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CustomException(String message, Throwable cause, Integer code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
