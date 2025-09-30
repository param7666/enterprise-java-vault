package com.nit.ProductData;

import java.util.*;
import java.util.stream.Collectors;

import com.nit.DBHandler.DBConnection;
import java.sql.*;


public class ProductManagment {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from product02");
			ResultSet rs=ps.executeQuery();
			List<Product02> pr=new ArrayList<>();
			while(rs.next()) {
				pr.add(new Product02(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4))); 
			}
			List<Product02> result=pr.stream().filter(n->(n.getPrice()>100)).sorted(Comparator.comparingDouble(Product02::getPrice).reversed()).collect(Collectors.toList());
			result.forEach(System.out::println);
			} catch(Exception e)  {
			e.printStackTrace();
		}
		
	}
}
