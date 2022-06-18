package com.biricik.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	
	public TrackCoach(FortuneService fortuneService) {	
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do It: " + this.fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Track Coach: inside method doMyStartupStuff" );
	}
	
	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Track Coach: inside method doMyCleanupStuff" );
	}
	
	
	
	
	
	
	
	
	

}
