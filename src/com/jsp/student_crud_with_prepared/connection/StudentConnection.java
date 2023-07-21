package com.jsp.student_crud_with_prepared.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
	Connection connection = null;

	public static Connection getStudentConnection() {

//		Step-1 load/register

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://Localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "root";

			// Step Start Connection
			Connection connection = DriverManager.getConnection(url, user, pass);

			
			return connection;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
