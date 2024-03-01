package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	// "say-hello" => "Hello! What are you learning today?"
	// Http://localhost:8080/say-hello
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("/say-hello-html")
	@ResponseBody
	public StringBuffer sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta charset=\"ISO-8859-1\">");
		sb.append("<title>My first HTML Page</title>");
		sb.append("</head>");
		sb.append("My first html page - changed.");
		sb.append("</body>");
		sb.append("</html>");
		
		
		
		return sb;
	}
	
	// Using a view like JSP
	// sayHello.jsp
	// "say-hello-jsp" => sayHello.jsp
	// /myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
