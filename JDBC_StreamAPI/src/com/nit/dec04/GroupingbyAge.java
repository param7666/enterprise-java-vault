package com.nit.dec04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingbyAge {
	public static void main(String[] args) {
		List<Person> p= Arrays.asList(
				new Person("Param",22),
				new Person("Vaibhav",12),
				new Person("Yogesh",22),
				new Person("Ishwar",12),
				new Person("Ketan",23),
				new Person("Mangesh",23)
				);
		Map<Integer, List<Person>> result=p.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(result);
		
	}
}
