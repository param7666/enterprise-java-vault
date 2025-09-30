package com.nit.bank;

import java.util.*;
import java.sql.*;

public class BankManagmentApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			System.out.println("======================================");
			System.out.println("===Wellcome to bank Application===");
			System.out.println("======================================");
			System.out.println("==Operations==");
			System.out.println("1.Create account");
			System.out.println("2.login account");
			System.out.println("Enter Your choice");
			int choice=Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				OpenAccount.open(con, sc);
				break;
			case 2:
				if(Login.login(con, sc)) {
					while(true) {
						System.out.println("===Options===");
						System.out.println("1.Withdrow");
						System.out.println("2.deposite");
						System.out.println("3.Transfer");
						System.out.println("Enter your operation");
						int op=Integer.parseInt(sc.nextLine());
						switch (op) {
						case 1:
							
							break;
						case 2:
							break;
							
						case 3:
							
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + op);
						}
					}
				} 
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
