package com.nit.bank;

import java.util.*;
import java.sql.*;
public class Login {
	public static boolean login(Connection con, Scanner sc) throws SQLException {
		PreparedStatement login=con.prepareStatement("select * from bank where name=? and accno=?");
		System.out.println("Enter name");
		String name=sc.nextLine();
		System.out.println("Enter Account number ");
		String acc=sc.nextLine();
		login.setString(1, name);
		login.setString(2, acc);
		ResultSet rs=login.executeQuery();
		if(rs.next()) {
			//System.out.println("Login Success");
			return true;
		}
		else {
			System.out.println("Please Enter valid Information");
			return false;
		}
	}
}
