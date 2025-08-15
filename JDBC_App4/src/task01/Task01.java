package task01;

import java.util.*;
import java.sql.*;

public class Task01 {
	static Scanner sc=new Scanner(System.in);
	public static void insert(Connection con) throws SQLException {
		PreparedStatement insert=con.prepareStatement("insert into emp_info values (?,?,?,?,?)");
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter name");
		String name=sc.nextLine();
		System.out.println("Enter email");
		String email=sc.nextLine();
		System.out.println("Enter phone number");
		long phno=Long.parseLong(sc.nextLine());
		System.out.println("Enter resume path");
		String path=sc.nextLine();
		
		insert.setInt(1, id);
		insert.setString(2, name);
		insert.setString(3, email);
		insert.setLong(4,phno);
		insert.setCharacterStream(5, new java.io.StringReader(path),path.length());
		
		int i=insert.executeUpdate();
		if(i>0) System.out.println("Data inserted successfully !!!");
		System.out.println("==========================================");
	}
}
