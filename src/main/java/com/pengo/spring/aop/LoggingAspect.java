package com.pengo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 15:28
 */
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public * com.pengo.spring.ioc.UserService.*(..))")
    public void doAccessCheck() {
        System.err.println("[Before] do access check...");
    }

    @Around("execution(public * com.pengo.spring.ioc.MailService.*(..))")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.err.println("[Around] start " + pjp.getSignature());
        Object proceed = pjp.proceed();
        System.err.println("[Around] done " + pjp.getSignature());
        return proceed;
    }
}
