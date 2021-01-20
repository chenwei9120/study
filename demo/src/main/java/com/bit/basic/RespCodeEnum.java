package com.bit.basic;

public enum  RespCodeEnum {

    SUCCESS("000", "请求成功"),
    FAIL("001", "请求失败");

    RespCodeEnum(String code, String messgage) {
        this.code = code;
        this.message = messgage;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println(RespCodeEnum.SUCCESS + ":" +
                RespCodeEnum.SUCCESS.code + ":" + RespCodeEnum.SUCCESS.message);
    }
}
