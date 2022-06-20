package com.biricik.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	// define a email and a team
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
