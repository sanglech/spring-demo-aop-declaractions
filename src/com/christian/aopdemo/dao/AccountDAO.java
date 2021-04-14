package com.christian.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.christian.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public String getName() {
		System.out.println(getClass()+ ": ing Get Name");	
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ ": in Set Name");	
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ ": in get Service Code");	
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ ": in Set service code");	
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount,boolean param1) {
		System.out.println(getClass()+ ": doing DB work adding an account");	
		}
	
	public boolean doWork() {
		System.out.println(getClass()+ "DOING WORK");
		return true;
		}
	
	public List<Account> findAccounts(boolean tripwire){
		
		List<Account> myAccounts= new ArrayList<Account>();
		
		//create sample accounts
		
		if(tripwire) {
			throw new RuntimeException("Test Exception");
		}
		
		Account p1= new Account("John","gold");
		Account p2= new Account("Chris","silver");
		Account p3= new Account("Puri","bronze");
		
		//add them to the list
		
		myAccounts.add(p1);
		myAccounts.add(p2);
		myAccounts.add(p3);
		
		
		return myAccounts;
		
	}
	
}
