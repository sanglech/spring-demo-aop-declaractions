package com.christian.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(50)
public class MyAPIAnalyticsAspect {
	@Before("com.christian.aopdemo.aspects.aopUtil.noGettersSetters()")
	public void performAPIAnalytics() {
		System.out.println("\n=========> Performing API Anlaytics");
		
	}
}
