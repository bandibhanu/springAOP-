package com.cg.app;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.app.service.Calculator;




public class FirstApp
{
    public static void main( String[] args )
    {
      Logger logger=Logger.getLogger(Calculator.class.getName());
        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
        Calculator calculator=context.getBean(Calculator.class);
        calculator.add(100,200);
        logger.info("result");
   
    }
}
