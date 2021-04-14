package com.christian.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.aopdemo.dao.AccountDAO;
import com.christian.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[]args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService fortuneService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		myLogger.info("---");
		myLogger.info("\n Main Program: AroundDemoApp");
		myLogger.info("---");
		myLogger.info(fortuneService.getFortune(false));
		//close the context
		context.close();
		myLogger.info("Finished.");
	}
}
