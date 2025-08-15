 package task02;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Maccess {
	static Scanner sc=new Scanner(System.in);
	public static void insert(Connection con) throws SQLException, FileNotFoundException, IOException {
		PreparedStatement ps=con.prepareStatement("insert into photos values (?,?)");
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Path");
		String path=sc.nextLine();
		
		try(FileInputStream file=new FileInputStream(path)) {
			ps.setInt(1, id);
			ps.setBinaryStream(2, file);
			int k=ps.executeUpdate();
			if(k>0) System.out.println("Photo Inserted");
			else System.out.println("Insertaion fail!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void retrive(Connection con) throws SQLException, FileNotFoundException, IOException {
		PreparedStatement ps=con.prepareStatement("select * from photos where id=?");
		String path="C:\\Users\\parme\\Test\\p1.JPG";
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			InputStream input=rs.getBinaryStream(2);
			try(FileOutputStream fos=new FileOutputStream(path)) {
				byte[] buffer=new byte[1024];
				int read;
				while((read=input.read(buffer))>0) {
					fos.write(buffer,0,read);
				}
				System.out.println("Photo Retrived");
				fos.close();			
			}
		}
		else {
			System.out.println("Photo Not retrived");
		}
	}
	public static Connection conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			return con;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
