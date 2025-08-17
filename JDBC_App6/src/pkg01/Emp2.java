package pkg01;

import java.util.*;
import java.sql.*;

public class Emp2 {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			
			PreparedStatement ps=con.prepareStatement("select * from employee2 where EMPID=?");
			System.out.println("Please Enter Emp Id");
			int id=Integer.parseInt(sc.nextLine());
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Emp Id: "+rs.getInt(1));
				System.out.println("Emp Name: "+rs.getString(2));
				System.out.println("Emp Address: "+rs.getString(3));
				System.out.println("Emp salary: "+rs.getLong(4));
				System.out.println("Emp Phone : "+rs.getLong(5));
			} else {
				System.out.println("Id not Found!!!!!");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
