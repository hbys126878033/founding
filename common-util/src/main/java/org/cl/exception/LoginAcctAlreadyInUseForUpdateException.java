package org.cl.exception;

/**
 * @Description: 更新Admin时如果检测到登录账号重复抛出这个异常
 * @Author: CL
 * @Date: 2021/1/21 21:57
 * @Version: 1.0
 */
public class LoginAcctAlreadyInUseForUpdateException extends RuntimeException{


    public LoginAcctAlreadyInUseForUpdateException() {
    }

    public LoginAcctAlreadyInUseForUpdateException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseForUpdateException(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
