package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	// /hello-world
	// returns "Hello World"
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	// Note the use of GetMapping instead of RequestMapping. This negates the need for the "method = RequestMethod.GET"
	@GetMapping(path="hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/basicauth")
	public String basicAuthCheck() {
		return "Success";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World bean");
	}
	
	// Path Parameters
	// /user/{id}/todos/{id} => /users/2/todos/200
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World,  %s", name));
	}
	
	@GetMapping(path="hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		
		//return "Hello World V2";
		
		//1:good.morning.message
		//2: 
//		- Example: 'en' - English (Good Morning)
//		- Example: 'nl' - Dutch (Goedemorgen)
//		- Example: 'fr' - French (Bonjour)
//		- Example: 'de' - Deutsch (Guten Morgen)
	}
	
}
