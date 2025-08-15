package pkg01;

import java.util.Scanner;
import java.sql.*;

public class Product {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try (sc){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","parmeshwar","12345");
			PreparedStatement ps1 = con.prepareStatement("insert into product68 values (?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from product68");
			PreparedStatement ps3=con.prepareStatement("select * from product68 where code = ?");
			PreparedStatement ps4=con.prepareStatement("update product68 set price=?,qty=? where code=?");
			PreparedStatement ps5=con.prepareStatement("delete from product68 where code=?");
			while (true) {
				System.out.println("====Operation choice====");
				System.out.println("1.Add product");
				System.out.println("2.View allproduct");
				System.out.println("3.view Product by code");
				System.out.println("4.update product by code (price-qty)");
				System.out.println("5.delete product by code");
				System.out.println("6.Exit");
				System.out.println("Enter your choice");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1: 
					System.out.println("Enter  Product Details");
					System.out.println("Product code");
					String prcode=sc.nextLine();
					System.out.println("product name");
					String prname=sc.nextLine();
					System.out.println("product price");
					float prprice=Float.parseFloat(sc.nextLine());
					System.out.println("product quentity");
					int prqty=Integer.parseInt(sc.nextLine());
					
					ps1.setString(1, prcode);
					ps1.setString(2, prname);
					ps1.setFloat(3, prprice);
					ps1.setInt(4, prqty);
					int k=ps1.executeUpdate();
					if(k>0) System.out.println("product added");
				
				break;
				
				case 2: 
					ResultSet rs=ps2.executeQuery();
					while(rs.next()) {
						System.out.println("Product Details");
						System.out.println("product code: "+rs.getString(1));
						System.out.println("Product name: "+rs.getString(2));
						System.out.println("Product price: "+rs.getFloat(3));
						System.out.println("Product Qry: "+rs.getInt(4));
					}
					
				break;
				case 3: 
					System.out.println("Enter product code");
					String prcd=sc.nextLine();
					ps3.setString(1, prcd);
					ResultSet rs2=ps3.executeQuery();
					if(rs2.next()) {
						System.out.println("Product Details");
						System.out.println("product code: "+rs2.getString(1));
						System.out.println("Product name: "+rs2.getString(2));
						System.out.println("Product price: "+rs2.getFloat(3));
						System.out.println("Product Qry: "+rs2.getInt(4));
					} else System.out.println("Product not found");
					break;
					
				case 4:
					System.out.println("Enter product code");
					String upc=sc.nextLine();
					System.out.println("Enter new price");
					Float nprice=Float.parseFloat(sc.nextLine());
					System.out.println("Enter new qty");
					int nqty=Integer.parseInt(sc.nextLine());
					ps4.setFloat(1, nprice);
					ps4.setInt(2, nqty);
					ps4.setString(3, upc);
					int updated=ps4.executeUpdate();
					if(updated>0) System.out.println("product updated");
					else System.out.println("product not found");
					break;
					
				case 5:
					System.out.println("Enter product code");
					String dlc=sc.nextLine();
					ps5.setString(1, dlc);
					int delete =ps5.executeUpdate();
					if(delete>0) System.out.println("Product deleted");
					else System.out.println("product not found");
					break;
					
				case 6: 
					System.out.println("Thank You !!!");
					con.close();
					System.exit(0);
					
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
