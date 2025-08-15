package Task01;

import java.util.*;
import java.sql.*;
public class Product {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			
			while(true) {
				System.out.println("=======Operations=======");
				System.out.println("1.Insert product details into table");
				System.out.println("2.Retrieve productdetails in forward direction.");
				System.out.println("3.Retrieve productdetails in reverse direction.");
				System.out.println("4.Retrieve 3rd record from top.");
				System.out.println("5.Retrieve 3rd record from bottom.");
				System.out.println("6.Retrieve last three record from product table.");
				System.out.println();
				System.out.println("Please Enter your choice");
				int choice=Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					MethodClass.insert(con);
					break;
				case 2:
					MethodClass.forwordShow(con);
					break;
				case 3:
					MethodClass.reverseShow(con);
					break;
				case 4:
					MethodClass.top(con);
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
