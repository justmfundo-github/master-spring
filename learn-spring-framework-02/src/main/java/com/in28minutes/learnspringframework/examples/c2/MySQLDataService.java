package com.in28minutes.learnspringframework.examples.c2;

import org.springframework.stereotype.Repository;

//Create the MySql service
//@Component
@Repository // More Specific annotation to the purpose of the class. @Repository means it is responsible for database related work
public class MySQLDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
	
}
