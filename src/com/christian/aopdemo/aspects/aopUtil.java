package com.christian.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class aopUtil {
	
	
	//create pointcut for DAO declarations
	@Pointcut("execution(* com.christian.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	//create pointcut on getter and setter methods
	@Pointcut("execution(* com.christian.aopdemo.dao.*.get*(..))")
	public void forGetters() {}
	
	
	//create pointcut to incude DAO and exlude getters and setters
	@Pointcut("execution(* com.christian.aopdemo.dao.*.set*(..))")
	public void forSetters() {}
	
	
	@Pointcut("forDAOPackage()&& !(forGetters() || forSetters())")
	public void noGettersSetters() {}
}
