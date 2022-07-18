package com.biricik.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addAccount() {
		System.out.println(getClass() +": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}
	public void delete() {
		System.out.println(getClass() + ": Membership delete ...");
	}
}
