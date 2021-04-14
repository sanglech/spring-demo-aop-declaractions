package com.christian.aopdemo.aspects;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.christian.aopdemo.Account;
import com.christian.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	@Before("com.christian.aopdemo.aspects.aopUtil.noGettersSetters()")
	public void beforePackageAdviceInPackage1(JoinPoint theJoinPoint) {
		myLogger.info("\n========> Execution @Before advice on everything in package not getters and setters");
		
		//display method signature
		MethodSignature methodSig= (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+ methodSig.toString());
		
		//display method args
		Object[] args = theJoinPoint.getArgs();
		
		for(Object a: args) {
			
			if(a instanceof Account) {
				Account theAccount = (Account)a;
				myLogger.info("Name: "+theAccount.getName());
				myLogger.info("Level: "+theAccount.getLevel());
			}
			
			else {
				myLogger.info("Arguments :"+a);
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
		
		myLogger.info("\n=====> Executing @AfterReturning on method: "+ method);
		
		//print out results of method call
		
		myLogger.info("\n=====> result is : "+ result);
		
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
		// print out which method we are advising  on
		
				String method = theJoinPoint.getSignature().toShortString();
				
				myLogger.info("\n=====> Executing @AfterThrowing on method: "+ method);
		//log the exception
				myLogger.info("\n=====>Exception is:  "+ theExc);		
				
	}
	
	@After("execution(* com.christian.aopdemo.dao.AccountDAO.findAccounts(..))")
	private void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising  on
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====> Executing @After(Finally) on method: "+ method);
	}
	
	
	@Around("execution(* com.christian.aopdemo.service.*.getFortune(..))")
	public Object getFortune(ProceedingJoinPoint thePJP) throws Throwable {
		
		// print out which method we are advising  on
		
		String method = thePJP.getSignature().toShortString();
		myLogger.info("\n=====> Executing @Around on method: "+ method);

		//get begin timestamp 
		long begin=System.currentTimeMillis();
		
		//execute the method
		Object result = thePJP.proceed();
		
		//get end timestamp
		long end=System.currentTimeMillis();
		
		//compute duration and display it
		
		myLogger.info("Time to execute "+ method+"  " +(end-begin)/1000.0+ " seconds.");
		
		
		return result;
	}
	
	
	
}
