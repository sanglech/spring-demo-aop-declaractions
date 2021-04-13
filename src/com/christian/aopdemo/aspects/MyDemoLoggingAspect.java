package com.christian.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.christian.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.christian.aopdemo.aspects.aopUtil.noGettersSetters()")
	public void beforePackageAdviceInPackage1(JoinPoint theJoinPoint) {
		System.out.println("\n========> Execution @Before advice on everything in package not getters and setters");
		
		//display method signature
		MethodSignature methodSig= (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+ methodSig.toString());
		
		//display method args
		Object[] args = theJoinPoint.getArgs();
		
		for(Object a: args) {
			
			if(a instanceof Account) {
				Account theAccount = (Account)a;
				System.out.println("Name: "+theAccount.getName());
				System.out.println("Level: "+theAccount.getLevel());
			}
			
			else {
				System.out.println("Arguments :"+a);
			}
			
		}
		
		
	}
	
}
