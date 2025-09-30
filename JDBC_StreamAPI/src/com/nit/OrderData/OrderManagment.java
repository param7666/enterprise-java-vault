package com.nit.OrderData;
import java.util.*;
import java.sql.*;
import com.nit.DBHandler.*;

public class OrderManagment {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc) {
			Connection con=DBConnection.connect();
			PreparedStatement rt=con.prepareStatement("select * from orderpr");
			ResultSet rs=rt.executeQuery();
			List<Order> order= new ArrayList();
			while(rs.next()) {
				order.add(new Order(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDate(4)));
			}
			List<Order> result=order.stream().filter(n->n.getAmount()>500).
					sorted(Comparator.comparing(Order::getDate)).
					sorted(Comparator.comparing(Order::getAmount)).
					limit(5).toList();
			result.forEach(o->System.out.println(o));
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
