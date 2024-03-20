package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

	@Pointcut("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.in28minutes.learnspringaop.aopexample.annotations.TrackTime)")
	public void TrackTimeAnnotaion() {}
}
