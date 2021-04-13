package com.christian.aopdemo.dao;

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
}
