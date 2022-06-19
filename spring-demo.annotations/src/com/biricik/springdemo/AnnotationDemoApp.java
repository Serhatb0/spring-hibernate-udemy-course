package com.biricik.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		TennisCoach theCoach = context.getBean("tennisCoach",TennisCoach.class); 
	
		// call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		// call metohd to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call method to get the email
		System.out.println(theCoach.getEmail());
		
		// call method to get the team
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();

	}

}
