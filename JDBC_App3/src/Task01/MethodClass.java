package Task01;
import java.util.*;
import java.sql.*;

public class MethodClass {
	static Scanner sc=new Scanner(System.in);
	
	public static void insert(Connection con) throws SQLException {
		PreparedStatement insert =con.prepareStatement("insert into product values (?,?,?,?)");
		System.out.println("Enter Product id");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter product name");
		String name=sc.nextLine();
		System.out.println("Enter product price");
		int price=Integer.parseInt(sc.nextLine());
		System.out.println("Enter product qty");
		int qty=Integer.parseInt(sc.nextLine());
		
		insert.setInt(1, id);
		insert.setString(2, name);
		insert.setInt(3, price);
		insert.setInt(4, qty);
		
		int i=insert.executeUpdate();
		if(i>0) System.out.println("Product Details Inserted !!!");
		System.out.println("================================");
	}
	
	public static void forwordShow(Connection con) throws SQLException {
		PreparedStatement fshow=con.prepareStatement("select * from product");
		ResultSet rs=fshow.executeQuery();
		System.out.println("Product Details in forword Direction");
		System.out.println("======================================");
		while(rs.next()) {
			System.out.println("Product id: "+rs.getInt(1));
			System.out.println("Product Name: "+rs.getString(2));
			System.out.println("Product Price: "+rs.getInt(3));
			System.out.println("Product Qty: "+rs.getInt(4));
			System.out.println();
		}
	}
	
	public static void reverseShow(Connection con) throws SQLException {
		PreparedStatement fshow=con.prepareStatement("select * from product");
		ResultSet rs=fshow.executeQuery();
		if(rs.last()) {
			System.out.println("Product Details in reverse Direction");
			System.out.println("======================================");
			do {
				System.out.println("Product id: "+rs.getInt(1));
				System.out.println("Product Name: "+rs.getString(2));
				System.out.println("Product Price: "+rs.getInt(3));
				System.out.println("Product Qty: "+rs.getInt(4));
				System.out.println();
			} while(rs.next());
		}
		
	}
	
	public static void top(Connection con) throws SQLException {
		PreparedStatement top=con.prepareStatement(" select * from product ");
		ResultSet rs=top.executeQuery();
		System.out.println("Top 3rd Record");
		System.out.println("==================================");
		int i=0;
		while(i<=3){
			if(i==3 || rs.next()) {
					System.out.println("Product id: "+rs.getInt(1));
					System.out.println("Product Name: "+rs.getString(2));
					System.out.println("Product Price: "+rs.getInt(3));
					System.out.println("Product Qty: "+rs.getInt(4));
					System.out.println();
				}
			i++;
		}
	}
}
