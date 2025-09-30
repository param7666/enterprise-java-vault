package com.nit.EmployeeSalary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class SalaryManagment {
	public static void main(String[] args) {
		List<Employee> empList=Arrays.asList(			//list of employee
				new Employee(1,"Amitabh","IT",2500.0),
				new Employee(2,"Salman","CS",3200.0),
				new Employee(3,"Aish","Mechanic",3400.0),
				new Employee(4,"Abhishek","PlayBoy",2200.0),
				new Employee(5,"Kaitrina","CS",4500));
		// varible.      stream connection. stram to double. avarage function.else list is empty
		Double average=empList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
		//System.out.println(average);
		empList.stream().filter(e->e.getSalary()>average).forEach(System.out::println);
		
	}
}
