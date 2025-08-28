package com.nit.task01;
import java.sql.*;
public class PsStatementClass {
	public static long pstm(Connection con) throws SQLException {
		int record=100;
		long pstime=0;
		PreparedStatement ps=con.prepareStatement("INSERT INTO users (id, name, email) VALUES (users_seq.NEXTVAL, ?, ?)");
		long start =System.currentTimeMillis();
		for(int i=1;i<=record;i++) {
			ps.setString(1, "Id"+i);
			ps.setString(2, "User"+i);
			ps.setString(3, "User"+i+"@example.com");
			ps.executeUpdate();
		}
		long end=System.currentTimeMillis();
		pstime=end-start;
		return pstime;
	}
}
