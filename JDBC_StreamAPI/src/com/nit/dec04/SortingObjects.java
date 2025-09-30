package com.nit.dec04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingObjects {
	public static void main(String[] args) {
		List<Person> p= Arrays.asList(
				new Person("Param",22),
				new Person("Vaibhav",12),
				new Person("Yogesh",24),
				new Person("Ishwar",18),
				new Person("Ketan",23),
				new Person("Mangesh",25)
				);
		List<Person> result=p.stream().sorted(Comparator.comparing(Person::getAge)).toList();
		result.forEach(System.out::println);
	}
}
