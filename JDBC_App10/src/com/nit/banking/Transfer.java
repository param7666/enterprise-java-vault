package com.nit.banking;
import java.util.*;

import com.nit.exception.InValidAccountNumberException;
import com.nit.exception.InsufficientBalanceException;

import java.sql.*;

public class Transfer {
	public static void trns(Connection con) throws SQLException, InsufficientBalanceException, InValidAccountNumberException {
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			 con.setAutoCommit(false);
			System.out.println("Enter your account number");
			int sacc=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Reciver account number");
			int racc=Integer.parseInt(sc.nextLine());
			System.out.println("Enter amount ");
			double amount=Double.parseDouble(sc.nextLine());
			PreparedStatement ps=con.prepareStatement("update banking_system set balance=? where accnumber=?");
			if(Check.verifyBalace(con, sacc, amount)) {
				ps.setDouble(1, amount);
				ps.setInt(2, racc);
				int k=ps.executeUpdate();
				con.commit();
				if(k>0) {
					updateAmmount(con, sacc, amount);
					System.out.println("Amount transfer sucessfully!!!");
					
				} else {
					System.out.println("Transaction fail...");
				}
			}
		} catch(SQLException e) {
			con.rollback();
			System.out.println("Trasaction fail roll back Status: "+e.getMessage());
		} finally {
			con.setAutoCommit(false);
		}
	
	}
	
	public static void updateAmmount(Connection con,int acc,double amount) throws SQLException {
		double balnce=0;
		PreparedStatement ps=con.prepareStatement("update banking_system  set balance=? where accnumber=?");
		PreparedStatement ps2=con.prepareStatement("SELECT balance FROM banking_system  WHERE accnumber = ?");
		ps2.setInt(1, acc);
		ResultSet rs=ps2.executeQuery();
		if(rs.next()) {
			balnce=rs.getDouble(1);
		} 
		double ub=balnce-amount;
		ps.setDouble(1,ub);
		ps.setInt(2, acc);
		int k=ps.executeUpdate();
	}
}
