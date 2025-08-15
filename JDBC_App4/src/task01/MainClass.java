package task01;

import java.util.*;
import java.sql.*;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			
			while(true) {
				System.out.println("=============Operations=============");
				System.out.println("Insert data");
				System.out.println("");
				System.out.println();
				System.out.println();
				System.out.println("====================");
				System.out.println("Enter your choice");
				int choice=Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					Task01.insert(con);
					break;
				
				
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
