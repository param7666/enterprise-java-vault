package com.nit.dec02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByAge {
	public static void main(String[] args) {
		List<Person> person=Arrays.asList(
				new Person("Rahul",22),
				new Person("Param",21),
				new Person("Kishor",25),
				new Person("Ramesh",27),
				new Person("Yogesh",24),
				new Person("Rakesh", 24),
				new Person("Tanvir", 22)
				);
		Map<Integer, List<Person>> groupedValue=person.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(groupedValue);
	}

}
