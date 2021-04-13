package com.christian.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this where we add all of our related advices for logging
	
	@Pointcut("execution(* com.christian.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforePackageAdviceInPackage1() {
		System.out.println("\n========> Execution @Before advice on everything in package()");
		
	}
	
	
	@Before("forDAOPackage()")
	public void beforePackageAdviceInPackage2() {
		System.out.println("\n@@@@@@@@@@@@@> Execution @Before advice on everything in packaage()");
		
	}
	
	
}
