package com.biricik.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging 

	// let's start with an @Before advice

	
	@Pointcut("execution(* com.biricik.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	
	
//	@Before("execution(* add*(com.biricik.aopdemo.Account,boolean))")
//	@Before("execution(* add*(com.biricik.aopdemo.Account,..))")
//	@Before("execution(* add*(..))")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API Analystics");
	}

}

