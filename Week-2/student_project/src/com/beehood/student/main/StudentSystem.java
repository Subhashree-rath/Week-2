package com.beehood.student.main;

import java.util.Scanner;
import com.beehood.student.model.Student;
import com.beehood.student.service.StudentService;

public class StudentSystem {

	public static void main(String[] args) {

		Scanner sb = new Scanner(System.in);
		StudentService service = new StudentService();
		int choice;

		do {
			System.out.println("\n===== STUDENT RECORD SYSTEM =====");
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Search Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter Choice: ");

			while (!sb.hasNextInt()) {
				System.out.print("Invalid! Enter valid choice only. ");
				sb.next();
			}

			choice = sb.nextInt();

			switch (choice) {

			case 1:
				int id;
				while (true) {
					System.out.print("Enter ID: ");
					if (sb.hasNextInt()) {
						id = sb.nextInt();
						if (id > 0) {
							break;
						} else {
							System.out.print("ID must be positive!");
						}
					} else {
						System.out.println("Invalid ID!");
						sb.next();
					}
				}
				sb.nextLine();

				String name;
				while (true) {
					System.out.print("Enter Name: ");
					name = sb.nextLine();
					if (name.trim().isEmpty()) {
						System.out.println("Name cannot be empty!");
					} else if (!name.matches("[a-zA-Z ]+")) {
						System.out.println("Name must contain letters only!");
					} else {
						break;
					}
				}

				double marks;
				while (true) {
					System.out.print("Enter Marks: ");
					if (sb.hasNextDouble()) {
						marks = sb.nextDouble();
						if (marks >= 0 && marks <= 600) {
							break;
						} else {
							System.out.println("Marks must be between 0 and 600!");
						}
					} else {
						System.out.println("Invalid Marks!");
						sb.next();
					}
				}

				Student st = new Student(id, name, marks);
				service.addStudent(st);
				break;

			case 2:
				service.viewStudents();
				break;

			case 3:
				int searchId;
				while (true) {
					System.out.print("Enter ID to Search: ");
					if (sb.hasNextInt()) {
						searchId = sb.nextInt();
						break;
					} else {
						System.out.println("Invalid ID!");
						sb.next();
					}
				}
				service.searchStudent(searchId);
				break;

			case 4:
				int deleteId;
				while (true) {
					System.out.print("Enter ID to Delete: ");
					if (sb.hasNextInt()) {
						deleteId = sb.nextInt();
						break;
					} else {
						System.out.println("Invalid ID!");
						sb.next();
					}
				}
				service.deleteStudent(deleteId);
				break;

			case 5:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 5);
	}
}