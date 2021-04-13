package com.christian.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(25)
public class MyCloudLogAspect {

	@Before("com.christian.aopdemo.aspects.aopUtil.noGettersSetters()")
	public void performCloudAnalytics() {
		System.out.println("\n==========> Performing Cloud Analytics");
		
	}
}
