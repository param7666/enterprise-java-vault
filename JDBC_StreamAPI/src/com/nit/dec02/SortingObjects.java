package com.nit.dec02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person{
	String name;
	int age;
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return "Name: "+name+" Age: "+age+"\n";
	}
}


public class SortingObjects {
	public static void main(String[] args) {
		List<Person> person=Arrays.asList(
				new Person("Rahul",22),
				new Person("Param",21),
				new Person("Kishor",25),
				new Person("Ramesh",27),
				new Person("Yogesh",24)
				);
		List<Person> str=person.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());
		str.forEach(System.out::println);
		
	}
}
