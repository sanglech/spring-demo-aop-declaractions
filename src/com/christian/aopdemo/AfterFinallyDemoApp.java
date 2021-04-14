package com.christian.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {
	public static void main(String[]args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO= context.getBean("accountDAO",AccountDAO.class);
		List<Account> theAccounts=null;
		
		try {
			//add boolean flag to simulate exception
			boolean tripwire=false;
			theAccounts=theAccountDAO.findAccounts(tripwire);
		

		}catch(Exception e) {
			System.out.println("\n Main Program caught exception"+ e);
		}
		System.out.println("\n Main Program: AfterThrowingDemoApp");
		System.out.println("---");
		System.out.println(theAccounts);
		
		//close the context
		context.close();
	}
}
