package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// YourBusinessClass
@Component
class YourBusinessClass{
	
	// Dependency injection using field injection
	Dependency1 dependency1;
	Dependency2 dependency2;
	
	
	// Dependency injection using constructor injection
	@Autowired //In the case of a constructor injection the @Autowired annotation is optional. Injection will happen regardless.
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	
	
	
	// Dependency injection using setters
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1 ");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2 ");
//		this.dependency2 = dependency2;
//	}



	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}
// Dependency1
@Component
class Dependency1{}
// Dependency2
@Component
class Dependency2{}

@Configuration
@ComponentScan // Scan automatically happens within the current package unless a package is specified
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
		}
	}

}
