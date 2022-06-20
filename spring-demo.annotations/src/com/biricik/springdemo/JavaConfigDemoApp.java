package com.biricik.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		TennisCoach theCoach = context.getBean("tennisCoach",TennisCoach.class); 
	
		// call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		// call metohd to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		
		// close the context
		context.close();

	}

}
