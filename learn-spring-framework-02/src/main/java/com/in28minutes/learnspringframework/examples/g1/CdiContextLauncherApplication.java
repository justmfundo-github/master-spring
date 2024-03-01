package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	private DataService dataService;

	
	public DataService getDataService() {
		System.out.println("Setter injection performed..");
		return dataService;
	}

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan // Scan automatically happens within this package
public class CdiContextLauncherApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}
	}

}
