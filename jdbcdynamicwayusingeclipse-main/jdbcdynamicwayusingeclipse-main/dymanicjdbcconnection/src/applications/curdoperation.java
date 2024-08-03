package applications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class curdoperation {
	private static final String Driver ="com.mysql.cj.jdbc.Driver";
    private static final String username ="root";
    private static final String password ="Mysql@123";
    private static final String url ="jdbc:mysql://localhost:3306/hiber";
    private static Connection conn;
    private static PreparedStatement pmst;
	
   //dowhile,switch(or)ifelse,jdbc,exception handling.
    public static void main(String[] args) {
		
    	int ch;
    	do {
    		System.out.println("curd operation");
    		System.out.println("*************");
    		Display();
    		Scanner scr =new Scanner(System.in);
			System.out.println("enter your choice :");
			ch = Integer.parseInt(scr.next());
			System.out.println("************");
			
			switch (ch) {
			case 1:
				CreateDatabase();
				break;
			case 2:
				DropDatabase();
				break;
			case 3:
				CreateTable();
				break;
			case 4:
				DropTable();
				break;
			case 5:
				InsertData();
				break;
			case 6:
				UpdateData();
				break;
			case 7:
				DeleteData();
				break;
			case 8:
				Getall();
				break;
			case 9:
				GetByEmail();
				break;
			case 10:
				System.exit(0);
				break;
			default:
				System.out.println("invalid");
			}
		} while (ch>0);
	}
    private static void GetByEmail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter table name");
			String sql = "select * from "+ sc.next()+ " where email = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee email");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
			System.out.println("id"+ rs.getInt("id")+ 
					"name"+rs.getString("name")+
					"email"+rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void Getall() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter table name");
			String sql = "select * from "+sc.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
			System.out.println("id"+ rs.getInt("id")+ 
					"name"+rs.getString("name")+
					"email"+rs.getString("email"));
			}      
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void DeleteData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "delete from "+sc.next()+ " where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Deleted");
			}
			else {
				System.out.println("error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void UpdateData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Table name:");
			String sql = "update "+sc.next()+" set name = ?,email = ? where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter name:");
			pmst.setString(1, sc.next());
			System.out.println("Enter Email:");
			pmst.setString(2, sc.next());
			System.out.println("Enter Id:");
			pmst.setInt(3, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Updated");
			}
			else {
				System.out.println("error");
			}
		} catch (Exception e) {
			e.printStackTrace();  
		}
		
	}

	private static void InsertData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "insert into "+sc.next()+"(id,name,email) values (?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter name");
			pmst.setString(2, sc.next());
			System.out.println("Enter email");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Inserted");
			}
			else {
				System.out.println("error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void DropTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "drop table "+ sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Table dropped");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void CreateTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "create table "+ sc.next() + "(id int,name varchar(20),email varchar(30))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Table created");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void DropDatabase() {
		String url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database Name");
			String sql ="drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("database dropped");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	private static void CreateDatabase() {
		String url ="jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database Name");
			String sql = "create database "+ sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0){
				System.out.println("Database Created");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

private static void Display() {
	System.out.println("\t1.create data");
	System.out.println("\t2.drop data");
	System.out.println("\t3.create table");
	System.out.println("\t4.drop table");
	System.out.println("\t5.insertion ");
	System.out.println("\t6.update ");
	System.out.println("\t7.Delete");
	System.out.println("\t8.Get all");
	System.out.println("\t9.Getbyemail");
	System.out.println("\t10.Exit");
}

}
