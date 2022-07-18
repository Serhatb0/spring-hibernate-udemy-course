package com.biricik.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.biricik.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
