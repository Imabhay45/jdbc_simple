package com.jsp.student_crud_with_prepared.service;

import com.jsp.student_crud_with_prepared.dao.StudentDao;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();

	public Student insertStudentService(Student student) {

		System.out.println("insertService method started.");

		if (student.getStudentId() <= 9999) {
			Student student2 = studentDao.insertStudent(student);
			System.out.println("inserService method ended!!");

			return student2;

		} else {
			System.err.println("pass 4 digits id");
		}
		return null;
	}

	/*update student data methods*/
	public int updateStudentNameService(int studentId, String studentName) {

		return studentDao.updateStudentName(studentId, studentName);
	}

	/*this method will update student email*/
	public int updateStudentEmailService(int studentId, String studentEmail) {

		return studentDao.updateStudentEmail(studentId, studentEmail);
	}

	/* this method will update student phone number*/
	public int updateStudentPhoneService(int studentId, long studentPhone) {

		return studentDao.updateStudentPhone(studentId, studentPhone);
	}
	/* this is display method which will display all data of students*/
	public void displayStudentDetails() {
		studentDao.displayStudentDetails();
	}
	public int deleteStudentById(int id) {
		
		return studentDao.deleteStudentById(id);
	}
}
