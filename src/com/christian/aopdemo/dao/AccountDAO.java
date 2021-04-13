package com.christian.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.christian.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount,boolean param1) {
		System.out.println(getClass()+ ": doing DB work adding an account");	
		}
	
	public boolean doWork() {
		System.out.println(getClass()+ "DOING WORK");
		return true;
		}
}
