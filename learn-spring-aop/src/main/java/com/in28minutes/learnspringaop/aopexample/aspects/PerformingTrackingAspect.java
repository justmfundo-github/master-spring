package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformingTrackingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	//@Around("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	@Around("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.TrackTimeAnnotaion()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		//Start a timer
		
		long startTimeMillis = System.currentTimeMillis();
		//Execute a method
		Object returnValue = proceedingJoinPoint.proceed();
		
		//Stop the time
		long stopTimeMillis = System.currentTimeMillis();
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around Aspect - {} Method executed in {}", proceedingJoinPoint , executionDuration);
		
		return returnValue;
	}
}
