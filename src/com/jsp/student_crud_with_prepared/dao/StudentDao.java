package com.jsp.student_crud_with_prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.student_crud_with_prepared.connection.StudentConnection;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	/**
	 * insert method for student
	 */

	public Student insertStudent(Student student) {
		// jdbc code
		String insertQuery = "insert into student values(?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentEmail());
			preparedStatement.setLong(4, student.getStudentPhone());

			preparedStatement.execute();

			return student;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/* method insert ends*/
	/* student data update method*/
	public int updateStudentName(int studentId, String studentName) {
		String updateStudentNameQuery = "update student set name=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStudentNameQuery);

			preparedStatement.setInt(2, studentId);
			preparedStatement.setString(1, studentName);

			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}
	}

	public int updateStudentEmail(int studentId, String studentEmail) {
		String updateStudentEmailQuery= "update student set email=? where id=?";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(updateStudentEmailQuery);
			
			preparedStatement.setInt(2, studentId);
			preparedStatement.setString(1, studentEmail);
			
			return preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
			return 0;
		}
}
	public int updateStudentPhone(int studentId, long studentPhone) {
			String updateStudentPhoneQuery= "update student set phone=? where id=?";
			try {
				PreparedStatement preparedStatement= connection.prepareStatement(updateStudentPhoneQuery);
				
				preparedStatement.setInt(2, studentId);
				preparedStatement.setLong(1, studentPhone);
				
				return preparedStatement.executeUpdate();
				
			}catch(SQLException e){
				e.printStackTrace();
				
				return 0;
			}
	}

	public void displayStudentDetails() {
		String displayStudentQuery = "SELECT * FROM student";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayStudentQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			
//			while() {
			resultSet.next();
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			long phone = resultSet.getLong("phone");

			System.out.println("id=" + id);
			System.out.println("name=" + name);
			System.out.println("email=" + email);
			System.out.println("phone=" + phone);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public int deleteStudentById(int studentId) {
		String deleteStudentQuery = "delete FROM student where id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
//			PreparedStatement preparedStatement
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
}
