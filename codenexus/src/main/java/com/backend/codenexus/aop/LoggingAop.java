package com.backend.codenexus.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAop {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingAop.class);

    @Around("execution(* com.backend.codenexus.*.*(..))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        Object result = proceedingJoinPoint.proceed();

        LOG.info("Executing " + className + "." + methodName);

        return result;
    }

    @Before("execution(* com.backend.codenexus.*.*(..))")
    public void beforeLogging(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getDeclaringTypeName();
        LOG.info("Entering " + className + "." + methodName);
    }

    @After("execution(* com.backend.codenexus.*.*(..))")
    public void afterLogging(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getDeclaringTypeName();
        LOG.info("Exiting " + className + "." + methodName);
    }
}