package com.biricik.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.biricik.aopdemo.dao.AccountDAO;
import com.biricik.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account account = new Account();
		account.setName("Serhat");
		account.setLevel("Silver");
		// call the business method
		accountDAO.addAccount(account,true);
		
		// cal the accountDao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("golden");
		
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		// call the membership business method 
		membershipDAO.addAccount();
		membershipDAO.delete();
		
		// close the context
		context.close();

	}

}
