package com.christian.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterReturning(
			pointcut="execution(* com.christian.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print pout which method we are advising  on
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====> Executing @AfterReturning on method: "+ method);
		
		//print out results of method call
		
		System.out.println("\n=====> result is : "+ result);
		
		//Modify data before it reaches calling program
		
		
		if(result!=null) {
			convertAccountsToUpperCase(result);
		}
		
	}

	private void convertAccountsToUpperCase(List<Account> result) {
		
		for(Account person: result) {
			String upperName= person.getName().toUpperCase();
			person.setName(upperName);
		}
		
	}
	
	
	
	@AfterThrowing(
			pointcut="execution(* com.christian.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	private void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print pout which method we are advising  on
		
				String method = theJoinPoint.getSignature().toShortString();
				
				System.out.println("\n=====> Executing @AfterThrowing on method: "+ method);
		//log the exception
				System.out.println("\n=====>Exception is:  "+ theExc);		
				
	}
	
	
}
