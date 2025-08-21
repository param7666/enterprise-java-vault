package com.nit.metaData;
import java.util.*;
import java.sql.*;
import com.nit.DBHandler.DBConnection;

public class Program01 {
	public static void main(String[] args) {
		try {
			Connection con=DBConnection.connect();
			
			System.out.println("===Database metadata===");
			DatabaseMetaData db1=con.getMetaData();
			System.out.println("Database product name: "+db1.getDatabaseProductName());
			System.out.println("Database Product virson: "+db1.getDatabaseProductVersion());
			System.out.println("Database Driver name: "+db1.getDriverName());
			
			PreparedStatement ps1=con.prepareStatement("insert into books values(?,?,?,?,?)");
			ParameterMetaData db2=ps1.getParameterMetaData();
			System.out.println("Maximum Column in table: "+db2.getParameterCount());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
