package com.nit.banking;
import java.util.*;
import com.nit.DBHandler.DBConnection;
import java.sql.*;
public class OnlineBankingSystem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect();
			while(true) {
				System.out.println("=======Operation=======");
				System.out.println("1.Transaction");
				System.out.println("2.Get Account Details");
				System.out.println("Enter Your Choice");
				int choice=Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					Transfer.trns(con);
					break;
				case 2:
					Details.show(con);
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
