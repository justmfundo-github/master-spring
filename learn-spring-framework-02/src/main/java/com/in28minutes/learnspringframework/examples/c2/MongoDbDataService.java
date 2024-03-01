package com.in28minutes.learnspringframework.examples.c2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//Create the MongoDb service
//@Component
@Repository // More Specific annotation to the purpose of the class. @Repository means it is responsible for database related work
@Primary
public class MongoDbDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {11, 22, 33, 44, 55};
	}
	
}
