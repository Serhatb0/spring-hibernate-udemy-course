package com.biricik.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.biricik.aopdemo.Account;

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
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		
		// display method arguments
		
		// get args
		Object[] args = joinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg:args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) tempArg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account name: " + account.getLevel());
			}
		}
		
	}
	
	
	
	

}

