package com.nit.Student69;

import java.util.*;
import java.sql.*;
import com.nit.DBHandler.*;

public class Student69 {
	public static void main(String[] args) {
		try {
			Connection con=DBConnection.connect();
			CallableStatement call=con.prepareCall("{call insertstd69(?,?,?,?)}");
			String id="s01";
			String name="param";
			String city="nanded";
			long phone=7666845l;
			call.setString(1, id);
			call.setString(2, name);
			call.setString(3, city);
			call.setLong(4, phone);
			call.execute();
			System.out.println("Data Addedd");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
