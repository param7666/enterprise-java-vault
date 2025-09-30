package com.nit.Books;
import java.util.*;
import java.sql.*;
public class BooksRetrive {
	static Scanner sc=new Scanner(System.in);
	public static void retrive(Connection con) throws SQLException {
		CallableStatement r=con.prepareCall("{call retrivebooks (?,?,?,?,?)}");
		r.setInt(1, 001);
		r.registerOutParameter(2, Types.VARCHAR);
		r.registerOutParameter(3, Types.VARCHAR);
		r.registerOutParameter(4, Types.VARCHAR);
		r.registerOutParameter(5, Types.DOUBLE);
		r.execute();
		System.out.println("=======Books Details=======");
		System.out.println("id: "+001);
		System.out.println("Title: "+r.getString(2));
		System.out.println("Author: "+r.getString(3));
		System.out.println("Genre: "+r.getString(4));
		System.out.println("Price: "+r.getDouble(5));
	}
}
