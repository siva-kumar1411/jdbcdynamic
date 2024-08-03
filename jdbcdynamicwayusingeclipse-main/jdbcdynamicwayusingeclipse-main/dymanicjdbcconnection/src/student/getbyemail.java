package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyemail {
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    //private static final String url ="jdbc:mysql://localhost:3306/";
    private static final String Username ="root";
	private static final String Password ="Mysql@123";
   public static void main(String[] args) {
		
		try {
			Scanner scr = new Scanner(System.in);
			System.out.println("provide database name:");
			String Url = "jdbc:mysql://localhost:3306/" +scr.next();
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(Url,Username,Password);
			System.out.println("enter table name");
			String sql ="select * from " +scr.next() +" where email =?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			System.out.println("enter email :");
			pmst.setString(1, scr.next());
			ResultSet rs  =pmst.executeQuery();
			while(rs.next()) {
				System.out.println("******");
				System.out.println("Id : " + rs.getInt("id"));
				System.out.println("NAME : " + rs.getString("name"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("******");
			}
					conn.close();
					pmst.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}
