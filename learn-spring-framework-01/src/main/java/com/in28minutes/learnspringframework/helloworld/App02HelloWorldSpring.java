package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacManGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1: Launch a spring context
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HellowWorldConfiguration.class)){
			
			// 2: Configure the things we want Spring to manage @Configuration
			// Did this by creating the HelloWorldConfiguration class 
			// Created a name method with @Bean annotation
			
			// 3: Retrieving Beans managed by Spring
			System.out.println("Name:" + context.getBean("name"));
			System.out.println("Age:" + context.getBean("age"));
			System.out.println("Person:\t\t" + context.getBean("person"));
			System.out.println("Person via method calls:" + context.getBean("person2MethodCall"));
			System.out.println("Person via parameters:\t" + context.getBean("person3Parameters"));
			System.out.println("Address1:\t\t" + context.getBean("customAddress1"));
			System.out.println("Address2:\t\t" + context.getBean("customAddress2"));
			
			// you can also call the bean by referencing the class name but there is a caveat
			// if there is more than one bean of that type in the configuration then java/spring doesn't know which one to use
			// One option to solve this is to mark one of the beans as a Primary bean
			System.out.println(context.getBean(Address.class)); 
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean("person5Qualifier"));
			
			// Listing all the available beans
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
			
		}		
	}

}
