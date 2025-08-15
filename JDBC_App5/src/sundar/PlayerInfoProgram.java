package sundar;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PlayerInfoProgram {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	try(s;){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
	PreparedStatement ps=con.prepareStatement("insert into player_Info values(?,?,?,?)");
	System.out.println("Enter Player Id: ");
	int pId=Integer.parseInt(s.nextLine());
	System.out.println("Enter Player Name: ");
	String pName=s.nextLine();
	 
	System.out.println("Enter Player Date Of Birth: ");
	String pDob=s.nextLine();
	try {
		Date.valueOf(pDob);
	} catch(IllegalArgumentException e) {
		e.getMessage();
	}
	System.out.println("Enter Image Path: ");
	String path=s.nextLine();
	s.next();
	File file=new File(path);
	if(!file.exists()) System.out.println("File not found!!!");
	
	try(FileInputStream fis=new FileInputStream(file);) {
		ps.setInt(1, pId);
		ps.setString(2, pName);
		ps.setDate(3,Date.valueOf(pDob));
		ps.setBlob(4,fis);
		int k=ps.executeUpdate();
		if(k>0) {
		System.out.println("Successfully Inserted...");
		} else System.out.println("Insertion fail!!!!!!!!!!!!");
	}catch (Exception e) {
		e.getMessage();
	}
	}catch (Exception e) {
		e.printStackTrace(); 
	}
}
}