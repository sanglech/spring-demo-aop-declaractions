package com.christian.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.aopdemo.dao.AccountDAO;
import com.christian.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {
	public static void main(String[]args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO= context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> theAccounts=theAccountDAO.findAccounts();
		
		System.out.println("\n Main Program: AfterReturningDemoApp");
		System.out.println("---");
		System.out.println(theAccounts);
		
		
		//close the context
		context.close();
	}
}
