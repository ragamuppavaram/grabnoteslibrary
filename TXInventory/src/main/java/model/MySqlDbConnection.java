package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDbConnection {
	private MySqlDbConnection() {

	}

	public static Connection getDbConnection() throws Exception {
		if (connection == null) {
			synchronized (Connection.class) {
				if (connection == null) {
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						connection = DriverManager.getConnection(connection_string, username, password);
						System.out.println("Database Connection was successfully established with MYSQL DB");
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

						throw new Exception("Error Connecting Database");
					}
				}
			}
		}
		return connection;
	}

	private static String connection_string = "jdbc:mysql://127.0.0.1:3306/books";
	private static String username = "root";
	private static String password = "newrootpassword";
	private static Connection connection = null;
}
