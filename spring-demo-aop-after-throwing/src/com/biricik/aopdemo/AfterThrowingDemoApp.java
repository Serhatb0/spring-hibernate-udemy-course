package com.biricik.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.biricik.aopdemo.dao.AccountDAO;
import com.biricik.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// call method to find the Accounts
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception" + e);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrownigDemoApp");
		System.out.println("----");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();

	}

}
