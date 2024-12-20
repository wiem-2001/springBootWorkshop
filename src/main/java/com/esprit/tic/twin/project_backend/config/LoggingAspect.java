package com.esprit.tic.twin.project_backend.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.esprit.tic.twin.project_backend.services.*.*(..))")
    public void logMethoodeExit1(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        log.info("In method : "+name+":");
    }

    @AfterReturning("execution(* com.esprit.tic.twin.project_backend.services.*.*(..))")
    public void logMethoodeExit2(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        log.info("In method : "+name+":");
    }
    @AfterThrowing("execution(* com.esprit.tic.twin.project_backend.services.*.*(..))")
    public void logMethoodeExit3(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        log.info("In method : "+name+":");
    }
    @After("execution(* com.esprit.tic.twin.project_backend.services.*.*(..))")
    public void logMethoodeExit4(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        log.info("In method : "+name+":");
    }
}
