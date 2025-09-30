package com.nit.mFile;

import java.util.*;
import java.sql.*;
import com.nit.DBHandler.*;

public class Mfile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect();
			//Insert.insert(con, sc);
			Retrive.retrive(con, sc);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
