package task02;

import java.util.Scanner;
import java.sql.*;
public class Employee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Connection con=Maccess.conn();
			Maccess.insert(con);
			Maccess.retrive(con);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
