package com.bit.basic.exception;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ErrorCode.java
 * @Description TODO
 * @createTime 2019年11月04日 17:20:00
 */
public interface ErrorCode {
    int getErrorCode();

    String getMessage();

    default PlatformException getException() {
        PlatformException exception = new PlatformException(this);
        return exception;
    }
}