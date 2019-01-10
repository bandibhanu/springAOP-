package com.cg.app.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;



@Service
public class Calculator {
	
	
	public Integer  add(int valueOne, int valueTwo) {
	      Logger logger=Logger.getLogger(Calculator.class.getName());

		logger.info("sum is :"+(valueOne+valueTwo));
		
	return (valueOne+valueTwo);
		
	}

}
