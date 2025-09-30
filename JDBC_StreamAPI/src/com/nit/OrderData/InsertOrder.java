package com.nit.OrderData;
import java.util.*;
import java.sql.*;
import java.sql.Date;

public class InsertOrder {
	static Scanner sc=new Scanner(System.in);
	public static void insert(Connection con) throws SQLException {
		CallableStatement in=con.prepareCall("{call insertorder(?,?,?,?)}");
		System.out.println("Enter order id");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter customer name");
		String name=sc.nextLine();
		System.out.println("Enter Amount");
		double amount=Double.parseDouble(sc.nextLine());
		System.out.println("Enter date");
		String dt=sc.nextLine();
		Date date=Date.valueOf(dt);
		in.setInt(1, id);
		in.setString(2, name);
		in.setDouble(3, amount);
		in.setDate(4, date);
		in.execute();
		System.out.println("Order Added");
	}
}
