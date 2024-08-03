package student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class users {
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String url ="jdbc:mysql://localhost:3306/?user=root";
    private static final String Username ="root";
	private static final String Password ="Mysql@123";
   public static void main(String[] args) {
		
		try {
			Scanner scr = new Scanner(System.in);
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(url,Username,Password);
			System.out.println("enter database name");
			String sql ="create database " +scr.next();
			PreparedStatement pmst = conn.prepareStatement(sql);
			int i =pmst.executeUpdate();
			if(i>0) {
				System.out.println("database created");
			}
			else {
				System.out.println("database not created");
			}
			conn.close();
			pmst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
