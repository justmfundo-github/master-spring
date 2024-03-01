package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		//MappingJacksonValue allows you to add serialization logic to the fields/bean
		MappingJacksonValue mappingJacksonValue = filterValues(someBean, "field1", "field3");
		
		return mappingJacksonValue;
	}
	
//	@GetMapping("/filtering-list")
//	public List<SomeBean> filteringList() {
//		return Arrays.asList(new SomeBean("value1", "value2", "value3"), 
//				new SomeBean("value4", "value4", "value5"),
//				new SomeBean("value6", "value7", "value8"));
//	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList(){
		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value4", "value4", "value5"),
				new SomeBean("value6", "value7", "value8"));
		
		MappingJacksonValue mappingJacksonValue = filterValues(someBeanList, "field2");
		return mappingJacksonValue;
	}
	
	public MappingJacksonValue filterValues(Object someBeanObject, String... fields) {
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanObject);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters );
		
		return mappingJacksonValue;
	}
}
