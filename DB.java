package g;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;

public class DB
{

private static String url;
private static String username;
private static String password;

private static Statement statement;
private static Connection connection;


DB(String url, String username, String password)
{
	this.url = url;
	this.username = username;
	this.password = password;
	
}


public static ArrayList<String> QueryDog(int n) throws SQLException
{
		ResultSet resultSet;
		ArrayList<String> arr = new ArrayList<>();
		

		try (Connection conn = DriverManager.getConnection(url, username, password)){

			System.out.println("Connection to DB succesfull!");
			statement = conn.createStatement();
			try {
				resultSet = statement.executeQuery("SELECT * FROM dogs");
			 	try {
					while(resultSet.next()){
						arr.add(resultSet.getString(n));
					}
					return arr;
					
				} catch (SQLException e) {
					e.printStackTrace();
					return arr;
				} 
			} catch (SQLException e1) {
				e1.printStackTrace();
				return arr;
			}

		}
	

	catch(Exception ex){
		System.out.println("Connection failed...");
		System.out.println(ex);
		return arr;
	}
}

public static ArrayList<String> QueryOwner(int n) throws SQLException
{
		ResultSet resultSet;
		ArrayList<String> arr = new ArrayList<>();
		

		try (Connection conn = DriverManager.getConnection(url, username, password)){

			System.out.println("Connection to DB succesfull!");
			statement = conn.createStatement();
			try {
				resultSet = statement.executeQuery("SELECT * FROM owners");
			 	try {
					while(resultSet.next()){
						arr.add(resultSet.getString(n));
					}
					return arr;
					
				} catch (SQLException e) {
					e.printStackTrace();
					return arr;
				} 
			} catch (SQLException e1) {
				e1.printStackTrace();
				return arr;
			}

		}
	

	catch(Exception ex){
		System.out.println("Connection failed...");
		System.out.println(ex);
		return arr;
	}
}

public static ArrayList<String> QueryAdr(int n) throws SQLException
{
		ResultSet resultSet;
		ArrayList<String> arr = new ArrayList<>();
		

		try (Connection conn = DriverManager.getConnection(url, username, password)){

			System.out.println("Connection to DB succesfull!");
			statement = conn.createStatement();
			try {
				resultSet = statement.executeQuery("SELECT * FROM adress");
			 	try {
					while(resultSet.next()){
						arr.add(resultSet.getString(n));
					}
					return arr;
					
				} catch (SQLException e) {
					e.printStackTrace();
					return arr;
				} 
			} catch (SQLException e1) {
				e1.printStackTrace();
				return arr;
			}

		}
	

	catch(Exception ex){
		System.out.println("Connection failed...");
		System.out.println(ex);
		return arr;
	}
}

public void AddUserData(String login,String pwd)
{
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to Store DB succesfull!");
        statement = conn.createStatement();
        
        Hasher hasher = new Hasher();
        byte[] salt = new byte[16];
    	salt = SecureRandom.getSeed(16);
    	String s = "";
    	String passwd = hasher.HashWithSalt(pwd, s);
    			
        int rows = statement.executeUpdate("INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000)," + 
        "('Galaxy S9', 45000), ('Nokia 9', 36000)");
        System.out.printf("Added %d rows", rows);
             
			 
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	catch(Exception ex){
	System.out.println("Connection failed...");
	System.out.println(ex);
	}
}

}
		






