package com.nit.mFile;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
public class Retrive {
	public static void retrive(Connection con,Scanner sc) throws SQLException, IOException {
		PreparedStatement ps=con.prepareStatement("select * from mfile where id=?");
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Enter path");
			String path=sc.nextLine();
			File file=new File(path);
			FileOutputStream fis=new FileOutputStream(file);
			Blob b=rs.getBlob(2);
			byte by[]=b.getBytes(1, (int) b.length());
			fis.write(by);
			System.out.println("File Retrived");
			fis.close();
		} else {
			System.out.println("File not Retrived");
		}
		
	}
}
