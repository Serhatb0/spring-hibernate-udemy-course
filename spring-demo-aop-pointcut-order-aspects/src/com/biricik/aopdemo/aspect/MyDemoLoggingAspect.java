package com.biricik.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging 

	// let's start with an @Before advice

	
	
	
//	@Before("execution(* add*(com.biricik.aopdemo.Account,boolean))")
//	@Before("execution(* add*(com.biricik.aopdemo.Account,..))")
//	@Before("execution(* add*(..))")
	@Before("com.biricik.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount");
	}
	
	
	
	

}

