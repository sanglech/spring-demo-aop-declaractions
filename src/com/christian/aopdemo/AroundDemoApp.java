package com.christian.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.aopdemo.dao.AccountDAO;
import com.christian.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	public static void main(String[]args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService fortuneService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		System.out.println("---");
		System.out.println("\n Main Program: AroundDemoApp");
		System.out.println("---");
		System.out.println(fortuneService.getFortune());
		//close the context
		context.close();
		System.out.println("Finished.");
	}
}
