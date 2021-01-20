package com.bit.basic.exception;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomErrorCode.java
 * @Description TODO
 * @createTime 2019年11月04日 17:56:00
 */
public enum CustomErrorCode implements ErrorCode {

    UNKNOW_EXCEPTION(4100000, "异常");

    private Integer code;
    private String desc;

    private CustomErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public int getErrorCode() {
        return this.getCode();
    }

    @Override
    public String getMessage() {
        return this.getDesc();
    }
}