package com.nit.metaData;

import com.nit.DBHandler.DBConnection;
import java.sql.*;
public class Program02 {
	public static void main(String[] args) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps1=con.prepareStatement("select bookid,title,author,genre,price from books");
			PreparedStatement ps2=con.prepareStatement("Insert into books values(?,?,?,?,?)");
			ResultSet rs=ps1.executeQuery();
			System.out.println("=====ResultSet MetaData=====");
			ResultSetMetaData ob1=rs.getMetaData();
			System.out.println("Number of Column: "+ob1.getColumnCount());
			System.out.println("Column Names 1: "+ob1.getColumnName(1));
			System.out.println("Column Names 2: "+ob1.getColumnName(2));
			System.out.println("Column Names 3: "+ob1.getColumnName(3));
			System.out.println("Column Names 4: "+ob1.getColumnName(4));
			System.out.println("Column Names 5: "+ob1.getColumnName(5));
			ps2.setInt(1, 002);
			ps2.setString(2, "Book2");
			ps2.setString(3, "Author2");
			ps2.setString(4, "Genre2");
			ps2.setDouble(5, 500);
			
			int k=ps2.executeUpdate();
			if(k>0) {
				System.out.println("Data Added!!");
			} else System.out.println("Data Not Addedd");
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
