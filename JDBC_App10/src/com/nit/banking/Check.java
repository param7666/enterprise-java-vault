package com.nit.banking;
import java.sql.*;
import com.nit.exception.InValidAccountNumberException;
import com.nit.exception.InsufficientBalanceException;
import com.nit.exception.Message;

public class Check {
	public static boolean verifyBalace(Connection con,int acc,double amount) throws SQLException, InsufficientBalanceException, InValidAccountNumberException {
		//boolean verifyacc=verifyAccount(con, acc);
		boolean flag=false;
			PreparedStatement ps=con.prepareStatement("SELECT balance FROM banking_system WHERE accnumber = ? AND balance > ?");
			ps.setInt(1, acc);
			ps.setDouble(2, amount);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				flag =true;
			}else {
				throw new InsufficientBalanceException(Message.insufficient);
			}
		return flag;
		
	}
	
	public static boolean verifyAccount(Connection con,int accnumber) throws SQLException, InValidAccountNumberException {
		boolean flag=false;
		PreparedStatement ps=con.prepareStatement("select * from banking_system where accnumber=?");
		ps.setInt(1, accnumber);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			flag= true;
		} else {
			throw new InValidAccountNumberException(Message.acc);
		}
		return flag;
	}
}
