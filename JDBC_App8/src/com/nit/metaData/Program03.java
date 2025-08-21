package com.nit.metaData;

import com.nit.DBHandler.DBConnection;
import java.sql.*;
public class Program03 {
	public static void main(String[] args) {
		try {
			Connection con=DBConnection.connect();
			Statement stm=con.createStatement();
			int empid=001;
			String empname="virat";
			String empadd="Bengluru";
			String email="virat@";
			long phno=89998446l;
			double salary=2500.0;
			stm.addBatch("insert into employee_info values("+empid+",'" +empname+"','" +empadd+"','" +email+"'," +phno+","+salary+")");
			
			int k[]=stm.executeBatch();
			for(int i:k) {
				System.out.println("Query Executed "+i);
			}
			stm.clearBatch();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
