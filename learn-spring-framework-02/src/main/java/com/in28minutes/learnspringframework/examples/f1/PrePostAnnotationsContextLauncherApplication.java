package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	private SomeDependency someDependency= new SomeDependency();
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	@PostConstruct // Method will run right after the constructor has been completed but also before the main method runs
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy // Used to clean up resources right before the main method ends
	public void cleanUp() {
		System.out.println("Performing clean up");
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some logic using some dependency...");
		
	}
	
}

@Configuration
@ComponentScan // Scan automatically happens within this package
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
			
			System.out.println();
			System.out.println("START of methods in main");
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println("END of methods in main");
			System.out.println();
		}
	}

}
