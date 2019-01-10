package com.cg.app.proxy;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopProxi {

	Logger logger = Logger.getLogger(AopProxi.class.getName());

	@After("execution(* com.cg.app.service.*.*(..))")
	public void log1() {
		logger.info("After-Logger the method");
	}

	@Before("execution(* com.cg.app.service.*.*(..))")
	public void log2() {
		logger.info("Before-Logger the method");
	}

	@Around("execution(* com.cg.app.service.*.*(..))")
	public Integer log3(ProceedingJoinPoint pjp) throws Throwable {

		logger.info("Before-Logging the method");
		logger.info("Function Name is : " + pjp.getSignature());
		logger.info("parameters are :");
		Object[] params = pjp.getArgs();
		for (int i = 0; i < params.length; i++) {
			logger.info("paramas value at index " + i + " is " + params[i]);
		}

		Object retval = pjp.proceed();
		logger.info("After-Logging the method");
		return (Integer) retval;
	}
	@AfterReturning(pointcut="execution(* com.cg.app.service.*.*(..))",returning="retval")
	public void log4(Integer retval) {
		logger.info(" result="+retval);
		logger.info("hehheeeeeeeeeeeeeeeeeeeeee");
	}

}
