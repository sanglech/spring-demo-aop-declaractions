package com.christian.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.christian.aopdemo.aspects.aopUtil.noGettersSetters()")
	public void beforePackageAdviceInPackage1() {
		System.out.println("\n========> Execution @Before advice on everything in package not getters and setters");
		
	}
	
}
