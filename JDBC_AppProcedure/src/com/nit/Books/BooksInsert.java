package com.nit.Books;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BooksInsert {
	public static void insert(Connection con) throws SQLException {
		CallableStatement ct=con.prepareCall("{call insertBooks(?,?,?,?,?)}");
		ct.setInt(1, 001);
		ct.setString(2, "Book1");
		ct.setString(3, "Author1");
		ct.setString(4, "Genre1");
		ct.setInt(5, 455);
		ct.execute();
		System.out.println("data added success");
	}
}
