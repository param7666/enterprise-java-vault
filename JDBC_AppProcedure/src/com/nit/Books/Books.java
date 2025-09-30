package com.nit.Books;
import java.sql.*;
import java.util.Scanner;

import com.nit.DBHandler.*;
public class Books {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect();
			System.out.println("===================================");
			System.out.println("===Books Managment System===");
			System.out.println("===================================");
			System.out.println("1.insert");
			System.out.println("2.retrive");
			System.out.println("Enter Your Operation");
			int choice=Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				BooksInsert.insert(con);
				break;
			case 2:
				BooksRetrive.retrive(con);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
