package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class ClassA{}

@Component 
@Lazy
class ClassB{
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Some initialization logic here...");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something from ClassB");
	}
}

@Configuration
@ComponentScan // Scan automatically happens within this package
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
			
			System.out.println("Initialization of context is completed");
			context.getBean(ClassB.class).doSomething();
		}
	}

}
