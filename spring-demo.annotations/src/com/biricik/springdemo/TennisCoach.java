package com.biricik.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	// define a email and a team
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> Tennis Coach: inside default constructor");
	}

	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	// define a setter method

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">> TenisCoach: inside setFortuneService() method");
	 * this.fortuneService = fortuneService; }
	 */

	// define any method

	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println(">> TenisCoach: inside doSomeCrazyStuff() method");
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
