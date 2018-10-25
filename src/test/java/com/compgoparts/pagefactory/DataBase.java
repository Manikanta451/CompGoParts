package com.compgoparts.pagefactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
	public static Connection connection;
	public static Statement statement;
	public static ResultSet resultset;
	public static String result;
	
	public static void main(String[] args) {
		
	try {
		System.out.println("connect sql");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("connect sql db");
		connection = DriverManager.getConnection("jdbc:sqlserver://carwashsuperstor.db.10224143.hostedresource.com", "carwashsuperstor", "Carwash123@");
		System.out.println("Connectingg......");
		statement = (Statement) connection.createStatement();
		resultset = statement.executeQuery("SELECT * FROM Orders WHERE Id = 9227");
		while (resultset.next()) {
			result =  resultset.getString("CustomerName");
			System.out.println("Email : " + result);
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
		

	}
}	
