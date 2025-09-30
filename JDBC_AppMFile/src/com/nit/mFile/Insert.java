package com.nit.mFile;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
public class Insert {
	public static void insert(Connection con, Scanner sc) throws SQLException, FileNotFoundException {
		PreparedStatement ps=con.prepareStatement("insert into mfile values(?,?)");
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter path");
		String path=sc.nextLine();
		File f=new File(path);
		ps.setInt(1, id);
		if(f.exists()) {
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(2, fis,f.length());
			int k=ps.executeUpdate();
			if(k>0) System.out.println("File Inserted");
			else System.out.println("File not Inserted!!!");
		}
	}
}
