package org.cl.exception;

/**
 * @Description: 保存Admin时如果检测到登录账号重复抛出这个异常
 * @Author: CL
 * @Date: 2021/1/21 21:54
 * @Version: 1.0
 */
public class LoginAcctAlreadyInUseException extends RuntimeException {

    public LoginAcctAlreadyInUseException() {
    }

    public LoginAcctAlreadyInUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
