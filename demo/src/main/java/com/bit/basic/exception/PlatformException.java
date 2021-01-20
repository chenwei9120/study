package com.bit.basic.exception;


/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName PlatformException.java
 * @Description TODO
 * @createTime 2019年11月04日 17:17:00
 */
public class PlatformException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    public PlatformException() {
    }

    public PlatformException(ErrorCode errorCode) {
        this(errorCode.getErrorCode(), errorCode.getMessage());
    }

    public PlatformException(ErrorCode errorCode, Throwable cause) {
        this(errorCode.getErrorCode(), errorCode.getMessage(), cause);
    }

    public PlatformException(int errorCode, String message) {
        this(errorCode, message, (Throwable) null);
    }

    public PlatformException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public PlatformException(int errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getMessage() {
        return String.format("%d:%s", this.getErrorCode(), super.getMessage());
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public static void main(String[] args) {

    }

}