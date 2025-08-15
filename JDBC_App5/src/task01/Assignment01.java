package task01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.proxy.annotation.Pre;

public class Assignment01 {
	static Scanner sc=new Scanner(System.in);
	public static void insert(Connection con) throws SQLException {
		PreparedStatement dt=con.prepareStatement("insert into  studata values (?,?,?,?)");
		PreparedStatement add=con.prepareStatement("insert into atdAdd values (?,?,?,?)");
		PreparedStatement cont=con.prepareStatement("insert into stdcontact values (?,?,?)");
		
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter roll Number");
		String roll=sc.nextLine();
		System.out.println("Enter Student name");
		String name=sc.nextLine();
		System.out.println("Enter Branch");
		String branch=sc.nextLine();
		System.out.println("ENter house number");
		String hn=sc.nextLine();
		System.out.println("Enter city");
		String city=sc.nextLine();
		System.out.println("Enter pin code");
		int pin=Integer.parseInt(sc.nextLine());
		System.out.println("Enter mID");
		String mid=sc.nextLine();
		System.out.println("Enter phone number");
		long ph=Long.parseLong(sc.nextLine());
		
		dt.setInt(1, id);
		dt.setString(2, roll);
		dt.setString(3, name);
		dt.setString(4, branch);
		
		add.setInt(1, id);
		add.setString(2, hn);
		add.setString(3, city);
		add.setInt(4, pin);
		
		cont.setInt(1, id);
		cont.setString(2, mid);
		cont.setLong(3, ph);
		
		int i=dt.executeUpdate();
		int j=add.executeUpdate();
		int k=cont.executeUpdate();
		if(i>0 && j>0&& k>0) System.out.println("Data added Succesfully!!!");
		System.out.println("================================================");
	}
	
	public static void display(Connection con) throws SQLException {
		PreparedStatement dt=con.prepareStatement("select * from studata where stdid=? ");
		PreparedStatement add=con.prepareStatement("select * from atdAdd where stdid=?");
		PreparedStatement cont=con.prepareStatement("select * from atdAdd where stdid=?");
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		dt.setInt(1, id);
		add.setInt(1, id);
		cont.setInt(1, id);
		
		ResultSet rs1=dt.executeQuery();
		ResultSet rs2=add.executeQuery();
		ResultSet rs3=cont.executeQuery();
		
		if (rs1.next()) {
            System.out.println("Student ID: " + rs1.getInt(1));
            System.out.println("Student Roll Number: " + rs1.getString(2));
            System.out.println("Student Name: " + rs1.getString(3));
            System.out.println("Student Branch: " + rs1.getString(4));
        } else {
            System.out.println("No student found with ID: " + id);
            return; 
        }
        if (rs2.next()) {
            System.out.println("Student House: " + rs2.getString(2));
            System.out.println("Student City: " + rs2.getString(3));
            System.out.println("Student Pincode: " + rs2.getLong(4));
        } else {
            System.out.println("No address found for student ID: " + id);
        }
        if (rs3.next()) {
            System.out.println("Student House : " + rs3.getString(2));
            System.out.println("Student Phone Number: " + rs3.getString(3));
        } else {
            System.out.println("No contact details found for student ID: " + id);
        }
		
	}
}
