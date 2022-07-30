package bai14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	// Kết nối vào MySQL.
	 public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
	     String hostName = "localhost";
	     String dbName = "phong_cho_thue";
	     String userName = "root";
	     String password = "12345678900";
	     String port = "3306";

	     return getMySQLConnection(hostName, dbName, userName, password, port);
	 }
	 public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password, String port) throws SQLException, ClassNotFoundException {
	     // Khai báo class Driver cho DB MySQL
	     
		 
	     String connectionURL = "jdbc:mysql://" + hostName + ":" + port +"/" + dbName; //3306 la cong jdbc

	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password); // DriverManager.getConnection() để kết nối đến cơ sở dữ liệu MySQL.
	     return conn;
	 }
	 
}
