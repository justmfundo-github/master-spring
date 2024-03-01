package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // Scan automatically happens within this package
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}
	}

}
