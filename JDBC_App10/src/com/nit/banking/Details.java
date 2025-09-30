package com.nit.banking;
import java.sql.*;
import java.util.Scanner;

import com.nit.exception.InValidAccountNumberException;
public class Details {
	public static void show(Connection con) throws SQLException, InValidAccountNumberException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account number");
		int account=Integer.parseInt(sc.nextLine());
		PreparedStatement ps=con.prepareStatement("select * from banking_system where accnumber=?");
			if(Check.verifyAccount(con, account)) {
			ps.setInt(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Account number: "+account);
				System.out.println("Balance: "+rs.getDouble(3));
			}
		}
	}
}
