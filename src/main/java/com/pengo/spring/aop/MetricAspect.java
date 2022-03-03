package com.pengo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 15:47
 */
@Aspect
@Component
public class MetricAspect {
    @Around("@annotation(metricTime)")
    public Object metric(ProceedingJoinPoint pjp, MetricTime metricTime) throws Throwable {
        String value = metricTime.value();
        long now = System.currentTimeMillis();
        try {
            return pjp.proceed();
        }finally {
            System.err.println("[MetricAspect] " + value + " cost:" + (System.currentTimeMillis() - now) + "ms");
        }
    }
}
