package com.in28minutes.learnspringframework.examples.c2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan // Scan automatically happens within this package
public class BusinessCalculationServiceContextLauncherApplication {
	
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BusinessCalculationServiceContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		}
	}

}
