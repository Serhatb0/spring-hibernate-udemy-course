package com.biricik.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.biricik.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@After("execution(* com.biricik.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (Finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.biricik.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

		// log the exception
		System.out.println("\n=====>>> The Exception is: " + theExc);
	}

	// add a new advice for @AfterReturning on the Accounts method
	@AfterReturning(pointcut = "execution(* com.biricik.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);

		// let's post-process the data ... let's modify it :-)

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n=====>>> result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts

		for (Account tempAccount : result) {

			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name on the account
			tempAccount.setName(theUpperName);
		}

	}

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
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) tempArg;

				System.out.println("account name: " + account.getName());
				System.out.println("account name: " + account.getLevel());
			}
		}

	}

}
