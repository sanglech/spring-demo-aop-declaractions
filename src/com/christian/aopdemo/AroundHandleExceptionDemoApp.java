package com.christian.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.aopdemo.dao.AccountDAO;
import com.christian.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[]args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService fortuneService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		myLogger.info("---");
		myLogger.info("\n Main Program: AroundDemoApp");
		myLogger.info("---");
		
		
		try {
			boolean tripwire=true;
			myLogger.info(fortuneService.getFortune(tripwire));
		}catch(Exception e) {
			myLogger.info("Exception in Main: "+ e);
		}
		
		
		//close the context
		context.close();
		myLogger.info("Finished.");
	}
}
