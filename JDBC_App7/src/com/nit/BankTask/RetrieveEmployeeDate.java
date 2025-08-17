
package com.nit.BankTask;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.nit.DBHandler.DBConnection;
import java.sql.*;

public class RetrieveEmployeeDate {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect(); //connect to db
			PreparedStatement ps=con.prepareStatement("select * from emp02"); //query
			ResultSet rs=ps.executeQuery(); //result set for fetch data
			List<Employee02> dt=new ArrayList<>(); //List of employee obj to store fetch data
			while(rs.next()) {
				dt.add(new Employee02(rs.getInt(1),rs.getString(2),rs.getString(3))); // storing data to list
			}
			List<Employee02> it=dt.stream() //Created list for store it employee and connected to stream
					.filter(emp->emp.getDepartment() //filter the data using filter function
							.equalsIgnoreCase("it")) // condition to store it department employee obbj
					.sorted((e1,e2)->e1.getName().compareToIgnoreCase(e2.getName())) // sorted the it employee based on there name
					.collect(Collectors.toList()); // convert stream to list
			it.forEach(System.out::println); // print the list
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}