package pkg2;

import java.util.*;


import java.sql.*;

public class Student {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			PreparedStatement ps1=con.prepareStatement("insert into std values(?,?,?,?)");
			PreparedStatement ps2=con.prepareStatement("select * from std");
			PreparedStatement ps3=con.prepareStatement("select * from std where std_id=?");
			PreparedStatement ps4=con.prepareStatement("update std set grade=? where std_id=?");
			PreparedStatement ps5=con.prepareStatement("delete from std where std_id=?");
			
			while(true) {
				System.out.println("Operations");
				System.out.println("1.Add a new student record.");
				System.out.println("2.View all student records.");
				System.out.println("3.View a student's details by their ID.");
				System.out.println("4.Update a student's grade by their ID.");
				System.out.println("5.Delete a student record by their ID.");
				System.out.println("6.Exit the application.");
				System.out.println("Enter your choice");
				int choice=Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1: 
					System.out.println("Enter student details");
					System.out.println("Enter id");
					String id=sc.nextLine();
					System.out.println("Enter name");
					String name=sc.nextLine();
					System.out.println("Enter age");
					int age=Integer.parseInt(sc.nextLine());
					System.out.println("Enter grade");
					String grd=sc.nextLine();
					ps1.setString(1, id);
					ps1.setString(2, name);
					ps1.setInt(3, age);
					ps1.setString(4, grd);
					 int k=ps1.executeUpdate();
					 if(k>0) System.out.println("Details Added succesfully");
					 else System.out.println("Wrong details");
					 break;
					 
				case 2:
					System.out.println("Student details");
					ResultSet rs=ps2.executeQuery();
					while(rs.next()) {
						System.out.println("Student id: "+rs.getString(1));
						System.out.println("Student Name: "+rs.getString(2));
						System.out.println("Student Age: "+rs.getInt(3));
						System.out.println("Student Grade: "+rs.getString(4));
					}
					break;
					
				case 3:
					System.out.println("Enter  id");
					String sid=sc.nextLine();
					ps3.setString(1, sid);
					ResultSet rs2=ps3.executeQuery();
					if(rs2.next()) {
						System.out.println("Student id: "+rs2.getString(1));
						System.out.println("Student Name: "+rs2.getString(2));
						System.out.println("Student Age: "+rs2.getInt(3));
						System.out.println("Student Grade: "+rs2.getString(4));
					}
					else System.out.println("Student not found");
					break;
					
				case 4:
					System.out.println("Enter id");
					String id2=sc.nextLine();
					System.out.println("Enter Grade");
					String grd2=sc.nextLine();
					ps4.setString(1, grd2);
					ps4.setString(2, id2);
					int update=ps4.executeUpdate();
					if(update>0) System.out.println("Update success");
					else System.out.println("Update fail");
					break;
					
				case 5:
					System.out.println("Enter id");
					String dlid=sc.nextLine();
					ps5.setString(1, dlid);
					int delete=ps5.executeUpdate();
					if(delete>0) System.out.println("Student details deleted");
					else System.out.println("Student not found");
					break;
					
				case 6:
					con.close();
					System.exit(0);
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
