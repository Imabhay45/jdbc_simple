package com.jsp.student_crud_with_prepared.controller;

//import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.Scanner;

import com.jsp.student_crud_with_prepared.dao.StudentDao;
import com.jsp.student_crud_with_prepared.dto.Student;
import com.jsp.student_crud_with_prepared.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("main method started!!!");

//		Student student=null;

		StudentService studentService = new StudentService();
		System.out.println("1.Insert\n2.Update\n3.Display\n4.Delete");
		System.out.println("enter option");

		int ch = scanner.nextInt();

		/* Student data insertion */
		switch (ch) {
		case 1: {
			System.out.println("Enter student id:");
			int id = scanner.nextInt();

			System.out.println("Enter student name:");
			String name = scanner.next();

			System.out.println("Enter student email:");
			String email = scanner.next();

			System.out.println("Enter student phone:");
			long phone = scanner.nextLong();

			Student student = new Student(id, name, email, phone);

			studentService.insertStudentService(student);
		}
			break;
		case 2: {
			/* Choose Update option */
			System.out.println("1.Name\n2.Email\n3.Phone");
			System.out.println("Please choose your option to update data");
			int ch1 = scanner.nextInt();

			switch (ch1) {

			/* Name update */
			case 1: {
				System.out.println("Enter student id:");
				int id = scanner.nextInt();

				System.out.println("Enter student name:");
				String name = scanner.next();

				int id1 = studentService.updateStudentNameService(id, name);

				if (id1 == 1) {
					System.out.println("Data___stored");
				} else {
					System.err.println("id not found, please enter correct id");
				}
			}
				break;
				
			/* Email Update */
			case 2: {
				System.out.println("Enter student id:");
				int id = scanner.nextInt();

				System.out.println("Enter student email:");
				String email = scanner.next();

				int id2 = studentService.updateStudentEmailService(id, email);

				if (id2 == 1) {
					System.out.println("Data___stored");
				} else {
					System.err.println("id not found, please enter correct id");
				}
			}
				break;

			// Phone Update
			case 3: {
				System.out.println("Enter student id:");
				int id = scanner.nextInt();

				System.out.println("Enter student phone:");
				long phone = scanner.nextLong();

				int id3 = studentService.updateStudentPhoneService(id, phone);

				if (id3 == 1) {
					System.out.println("Data___stored");
				} else {
					System.err.println("id not found, please enter correct id");
				}
			}
				break;
			}

			System.out.println("Data Stored");
		}
			break;
			
		/* Display Students data */

		case 3: {

			 studentService.displayStudentDetails();
			 System.out.println("Student Data Displayed");
		}
			break;

		/* Delete Data */
		case 4: {
			System.out.println("Enter student id:");
			int id = scanner.nextInt();
			
			studentService.deleteStudentById(id);
			System.out.println("data deleted");
		}

		default: {
			System.err.println("Enter valid input.");
		}
			break;
		}
	}
}