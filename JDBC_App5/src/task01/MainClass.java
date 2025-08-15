package task01;
import java.util.*;
import java.sql.*;
public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			
			while(true) {
				System.out.println("======OPERATION======");
				System.out.println("Insert Details");
				System.out.println("Show Details");
				System.out.println("Who faster check");
				int i=Integer.parseInt(sc.nextLine());
				
				switch (i) {
				case 1: 
					Assignment01.insert(con);
					break;
				case 2:
					Assignment01.display(con);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + i);
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
