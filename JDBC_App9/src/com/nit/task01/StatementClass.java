package com.nit.task01;
import java.sql.*;
public class StatementClass {
	public static long stm(Connection con) throws SQLException {
		int recond=100;
		long statement=0;
		Statement stm=con.createStatement();
		String sqlStatement = "INSERT INTO users (id, name, email) VALUES (users_seq.NEXTVAL, 'User%d', 'user%d@example.com')";
		long start=System.currentTimeMillis();
		for(int i=1;i<=recond;i++) {
			stm.executeUpdate(String.format(sqlStatement,i,i));
		}
		long end=System.currentTimeMillis();
		statement=end-start;
		return statement;
	}
}
