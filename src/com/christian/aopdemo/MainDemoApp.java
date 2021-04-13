package com.christian.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.aopdemo.dao.AccountDAO;
import com.christian.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[]args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO= context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO=  context.getBean("membershipDAO",MembershipDAO.class);
		
		
		Account theAccount= new Account();
		
		//point cut expression matches on ALL add account methods
		
		
		//call the buisness method
		System.out.println("Adding account");
		theAccountDAO.addAccount(theAccount,true);
		
		theAccountDAO.doWork();

		
		System.out.println("Adding membership DAO");
		theMembershipDAO.addPerson();
		
		
		System.out.println("Adding account in membership DAO");
		theMembershipDAO.addAccount();
		
		
		
		
		//close the context
		context.close();
	}
}
