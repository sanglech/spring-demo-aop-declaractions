package com.christian.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this where we add all of our related advices for logging
	
	
	//create pointcut for DAO declarations
	@Pointcut("execution(* com.christian.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	//create pointcut on getter and setter methods
	@Pointcut("execution(* com.christian.aopdemo.dao.*.get*(..))")
	private void forGetters() {}
	
	
	//create pointcut to incude DAO and exlude getters and setters
	@Pointcut("execution(* com.christian.aopdemo.dao.*.set*(..))")
	private void forSetters() {}
	
	
	@Before("forDAOPackage()&& !(forGetters() || forSetters())")
	public void beforePackageAdviceInPackage1() {
		System.out.println("\n========> Execution @Before advice on everything in package not getters and setters");
		
	}
	
	
	
}
