package task01;

import java.util.*;
import java.sql.*;
public class Task02 {
	static Scanner sc=new Scanner(System.in);
	
	public static void retrive(Connection con) throws SQLException {
		PreparedStatement rtv=con.prepareStatement("SELECT resume FROM emp_info WHERE id = ?;");
		System.out.println("Please enter id");
		int id=Integer.parseInt(sc.nextLine());
		rtv.setInt(1, id);
		
	}
			
}
