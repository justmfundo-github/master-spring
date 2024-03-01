package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{// A normal spring bean will be created as a singleton. I.e. One object instance per spring IoC container
	
}

//Prototype means different instances will be used/created each time the bean is used
// I.e. Possibly many object instances per spring IoC container
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{}

@Configuration
@ComponentScan // Scan automatically happens within this package
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
			
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
	}

}
