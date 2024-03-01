package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Eliminate verbosity in creating Java Beans
// Public accessor methods, constructor
// equals, hashcode and toString methods are automatically created 
// Released in JDK 16
record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HellowWorldConfiguration {

	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		Person person = new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() { // You can create a new bean using beans that have already been added to Spring
		return new Person(name(), age(), address()); // Note that we refer to each bean via it's method call
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address customAddress2) { 
		return new Person(name, age, customAddress2);// In this case we will refer to each bean by calling them using parameter variable names
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) { 
		return new Person(name, age, address);// In this case we will refer to each bean by calling them using parameter variable names
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("customAddress2") Address address) { 
		return new Person(name, age, address);// In this case we will refer to each bean by calling them using parameter variable names
	}
	
	@Bean(name="customAddress1")// you can customize the bean names as desired
	@Primary
	public Address address() {
		Address address = new Address("123 Yellow Brick rd", "Brooklyn");
		return address;
	}
	
	@Bean(name="customAddress2")// you can customize the bean names as desired
	@Qualifier("address2Qualifier")
	public Address address2() {
		Address address = new Address("123 Baker Street", "London");
		return address;
	}
}
