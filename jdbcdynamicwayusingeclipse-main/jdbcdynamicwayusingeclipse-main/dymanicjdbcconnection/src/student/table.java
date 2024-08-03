package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class table {
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String url ="jdbc:mysql://localhost:3306/stu";
    private static final String Username ="root";
	private static final String Password ="Mysql@123";
   public static void main(String[] args) {
		
		try {
			Scanner scr = new Scanner(System.in);
			System.out.println("provide database name:");
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(url,Username,Password);
			System.out.println("enter table name");
			String sql ="create table " +scr.next() +"(id int,name varchar(20),email varchar(30))";
			PreparedStatement pmst = conn.prepareStatement(sql);
			int i =pmst.executeUpdate();
			if(i==0) {
				System.out.println("table is created");
			}
			else {
				System.out.println("table not created");
			}
			conn.close();
			pmst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
