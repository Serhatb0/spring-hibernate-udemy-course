package com.biricik.springdemo.aspect;

import java.util.Iterator;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.biricik.springdemo.controller.*.*(..))")
	private void forControllerPackage() {};
	
	@Pointcut("execution(* com.biricik.springdemo.service.*.*(..))")
	private void forServicePackage() {};
	
	@Pointcut("execution(* com.biricik.springdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {};
	
	// add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: calling method: " + method);
		
		// get the Arguments
		Object[] args = joinPoint.getArgs();
		
		// loop thru and display args
		for (Object tempArg : args) {
			myLogger.info("====> argument: " + tempArg);
		}
	}
	
	
	// add @AfterReturning Advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result"
			)
	public void afterReturning(JoinPoint joinPoint ,Object result) {
		
		// display method we are returning from
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====>> in @AfterReturning: calling method: " + method);
		
		// display data returned
		myLogger.info("====> result: " + result);
		
	}
	
	
	
	
	
	
	
}
