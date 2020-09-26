package com.example.springsocial.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("applicationPackagePointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object response = null;
               String method = joinPoint.getSignature().toShortString();
        try {
            long startTime = System.currentTimeMillis();
            log.debug("Entering -" +joinPoint.getSignature().getDeclaringTypeName() + " :: " + joinPoint.getSignature().getName() +" :: args :: " + Arrays.toString(joinPoint.getArgs()));
            response = joinPoint.proceed();
            log.debug("Exiting -" +joinPoint.getSignature().getDeclaringTypeName() + " :: " + joinPoint.getSignature().getName() +" :: " + response + " :: Duration :: " +
                    (System.currentTimeMillis() -startTime) + " ms");
            return response;
        }catch (Exception e) {
            log.error("Exception while invoking method - " + method);
            throw  e;
        }
    }

    @Pointcut("within(com.example.springsocial..*)"
              +"&& !@annotation(com.example.springsocial.annotation.NoLogging)"
              + "&& !@target(com.example.springsocial.annotation.NoLogging)" )
    public void applicationPackagePointCut(){
        }


}
