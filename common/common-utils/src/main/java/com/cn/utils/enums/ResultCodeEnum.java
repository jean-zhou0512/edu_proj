package com.cn.utils.enums;

public enum ResultCodeEnum {
    SUCCESS(20000,"成功"),
    ERROR(20001,"失败");
    private int code;
    private String value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ResultCodeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
