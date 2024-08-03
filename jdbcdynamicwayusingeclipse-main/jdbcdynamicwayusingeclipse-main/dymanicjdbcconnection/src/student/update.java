package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
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
			String sql ="update " +scr.next()+" set name = ?, email=? where id= ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			System.out.println("enter name:");
			pmst.setString(1, scr.next());
			System.out.println("enter email:");
			pmst.setString(2, scr.next());
			System.out.println("enter id:");
			pmst.setInt(3, scr.nextInt());
			int i =pmst.executeUpdate();
			if(i>0) {
				System.out.println("table updated");
			}
			else {
				System.out.println("table not updated");
			}
			conn.close();
			pmst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
