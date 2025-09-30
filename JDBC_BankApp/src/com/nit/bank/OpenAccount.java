package com.nit.bank;

import java.util.*;
import java.sql.*;

public class OpenAccount {
	
	public static void open(Connection con, Scanner sc) throws SQLException {
		PreparedStatement ps=con.prepareStatement
				("insert into bank values (?,?,?,?,?,?,?)");
		System.out.println("Enter id");
		String id=sc.nextLine();
		System.out.println("Enter name");
		String name=sc.nextLine();
		System.out.println("Enter Adhar number");
		String adhar=sc.nextLine();
		System.out.println("Enter Address");
		String address=sc.nextLine();
		System.out.println("Enter phone number");
		long phno=Long.parseLong(sc.nextLine());
		String accno=generateRandomString(name);
		double balance=2000.00;
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, adhar);
		ps.setString(4, accno);
		ps.setDouble(5, balance);
		ps.setString(6, address);
		ps.setLong(7, phno);
		
		int o=ps.executeUpdate();
		if(o>0) System.out.println("Account open Success");
		else System.out.println("Lunch Time Come 2 days Latter");
		System.out.println("Thank You !!");
		
		
	}
	public static String generateRandomString(String input) {
        // Generate a random 6-digit number
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000); // Ensures a 6-digit number

        // Take the first 6 letters from the input string
        String prefix = input.length() >= 6 ? input.substring(0, 6) : input;

        // Combine the prefix and the random number
        return prefix + randomNumber;
    }
}
