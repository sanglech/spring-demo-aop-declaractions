package com.christian.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//return a forture
		
		return "It will be a good day";
		
		
	}

	public String getFortune(boolean tripwire) {
		if(tripwire) {
			throw new RuntimeException("O wurrr");
		}
		return getFortune();
	}
}
