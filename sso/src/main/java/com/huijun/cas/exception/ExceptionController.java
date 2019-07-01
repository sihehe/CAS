package com.huijun.cas.exception;


import org.apache.shiro.authc.AccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @program: cas
 * @description: 异常捕捉类
 * @author: Mr.si
 * @create: 2019-06-27 18:16
 **/

@RestControllerAdvice
public class ExceptionController {
    // 捕捉 MyRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public static String handleShiroException(Exception ex) {
        return ex.getMessage();
    }
}
