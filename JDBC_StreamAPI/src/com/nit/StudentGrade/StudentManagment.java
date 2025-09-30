package com.nit.StudentGrade;

import com.nit.DBHandler.DBConnection;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.*;

public class StudentManagment {
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.connect(); // connection
			PreparedStatement ps = con.prepareStatement("select * from student02"); //query
			ResultSet rs = ps.executeQuery(); // ResultSet for fetch data
			List<Student> std = new ArrayList<>(); // ArrayList for store table data fetched by ResultSet
			while (rs.next()) {
				std.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4))); //storing
			}
			List<Student> result = std.stream().filter(s -> (s.getGrade() > 85)).toList(); //list of Student hu scored marks 85 >
			Map<String, List<Student>> group=result.stream() //map for store groups
					.collect(Collectors.groupingBy(Student::getCourse,TreeMap::new, //tree map for sort course as accensding order
							Collectors.collectingAndThen(Collectors.toList(),//converting stream to list
									list->list.stream()
							.sorted(Comparator.comparingInt(Student::getGrade)).toList()))); //sorting
			
			System.out.println(group); //printing
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
