package com.nit.product68;
import java.util.*;
import java.sql.*;
import com.nit.DBHandler.*;
public class Product68 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect();
			CallableStatement st=con.prepareCall("{call InsertCustDetails68(?,?,?,?,?,?,?,?,?)}");
			System.out.println("Enter id");
			String id=sc.nextLine();
			System.out.println("Enter name");
			String name=sc.nextLine();
			System.out.println("Enter hno");
			String hn=sc.nextLine();
			System.out.println("Enter sname");
			String sname=sc.nextLine();
			System.out.println("Enter city");
			String city=sc.nextLine();
			System.out.println("State");
			String state=sc.nextLine();
			System.out.println("Pincode");
			int pcd=Integer.parseInt(sc.nextLine());
			System.out.println("Mail id");
			String mid=sc.nextLine();
			System.out.println("Phone number");
			Long pn=sc.nextLong();
			
			st.setString(1,id);
			st.setString(2, name);
			st.setString(3, hn);
			st.setString(4, sname);
			st.setString(5, city);
			st.setString(6, state);
			st.setInt(7, pcd);
			st.setString(8, mid);
			st.setLong(9, pn);
			
			st.execute();
			System.out.println("Details added successfully");
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
