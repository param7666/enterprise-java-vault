package com.nit.inout_procedure;

import java.sql.*;
import com.nit.DBHandler.*;

public class RetriveData {
	public static void main(String[] args) {
		try {
			Connection con=DBConnection.connect();
			CallableStatement ct=con.prepareCall("{call RetrieveCustDetails68(?,?,?,?,?,?,?,?,?)}");
			String id="aa2";
			ct.setString(1, id);
			ct.registerOutParameter(2, Types.VARCHAR);
			ct.registerOutParameter(3, Types.VARCHAR);
			ct.registerOutParameter(4, Types.VARCHAR);
			ct.registerOutParameter(5, Types.VARCHAR);
			ct.registerOutParameter(6, Types.VARCHAR);
			ct.registerOutParameter(7, Types.INTEGER);
			ct.registerOutParameter(8, Types.VARCHAR);
//			ct.registerOutParameter(8, Types.VARCHAR);
			ct.registerOutParameter(9, Types.BIGINT);
			ct.execute();
			System.out.println("Id: "+id);
			System.out.println("Name: "+ct.getString(2));
			System.out.println("HNO: "+ct.getString(3));
			System.out.println("S name: "+ct.getString(4));
			System.out.println("City: "+ct.getString(5));
			System.out.println("State: "+ct.getString(6));
			System.out.println("pincode: "+ct.getInt(7));
			System.out.println("M ID: "+ct.getString(8));
			System.out.println("phno: "+ct.getLong(9));
			
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
