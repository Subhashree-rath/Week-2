package com.beehood.employee.main;

import java.util.Scanner;
import com.beehood.employee.model.FullTimeEmployee;
import com.beehood.employee.model.Intern;
import com.beehood.employee.service.EmployeeService;

public class EmployeeSystem {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		int choice;

		do {
			System.out.println("\n===== EMPLOYEE SYSTEM =====");
			System.out.println("1. Add Full Time Employee");
			System.out.println("2. Add Intern");
			System.out.println("3. View All Employees");
			System.out.println("4. Search Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. View Full Time Only");
			System.out.println("7. View Interns Only");
			System.out.println("8. Exit");
			System.out.print("Enter Choice: ");

			while (!s.hasNextInt()) {
				System.out.println("Invalid! Enter numbers only.");
				s.next();
			}
			choice = s.nextInt();

			switch (choice) {

			case 1:
				int ftId;
				while (true) {
					System.out.print("Enter ID: ");
					if (s.hasNextInt()) {
						ftId = s.nextInt();
						if (ftId > 0)
							break;
						else
							System.out.println("ID must be positive!");
					} else {
						System.out.println("Invalid ID!");
						s.next();
					}
				}

				s.nextLine();

				String ftName;
				while (true) {
					System.out.print("Enter Name: ");
					ftName = s.nextLine();
					if (ftName.trim().isEmpty()) {
						System.out.println("Name cannot be empty!");
					} else if (!ftName.trim().matches("[a-zA-Z ]+")) {
						System.out.println("Letters only!");
					} else {
						break;
					}
				}

				double salary;
				while (true) {
					System.out.print("Enter Salary: ");
					if (s.hasNextDouble()) {
						salary = s.nextDouble();
						if (salary > 0)
							break;
						else
							System.out.println("Salary must be positive!");
					} else {
						System.out.println("Invalid Salary!");
						s.next();
					}
				}

				service.addEmployee(new FullTimeEmployee(ftId, ftName, salary));
				System.out.println("Full Time Employee Added!");
				break;

			case 2:
				int inId;
				while (true) {
					System.out.print("Enter ID: ");
					if (s.hasNextInt()) {
						inId = s.nextInt();
						if (inId > 0)
							break;
						else
							System.out.println("ID must be positive!");
					} else {
						System.out.println("Invalid ID!");
						s.next();
					}
				}

				s.nextLine();

				String inName;
				while (true) {
					System.out.print("Enter Name: ");
					inName = s.nextLine();
					if (inName.trim().isEmpty()) {
						System.out.println("Name cannot be empty!");
					} else if (!inName.trim().matches("[a-zA-Z ]+")) {
						System.out.println("Letters only!");
					} else {
						break;
					}
				}

				double stipend;
				while (true) {
					System.out.print("Enter Stipend: ");
					if (s.hasNextDouble()) {
						stipend = s.nextDouble();
						if (stipend > 0)
							break;
						else
							System.out.println("Stipend must be positive!");
					} else {
						System.out.println("Invalid Stipend!");
						s.next();
					}
				}

				service.addEmployee(new Intern(inId, inName, stipend));
				System.out.println("Intern Added!");
				break;

			case 3:
				service.viewEmployees();
				break;

			case 4:
				int searchId;
				while (true) {
					System.out.print("Enter ID to Search: ");
					if (s.hasNextInt()) {
						searchId = s.nextInt();
						break;
					} else {
						System.out.println("Invalid ID!");
						s.next();
					}
				}
				service.searchEmployee(searchId);
				break;

			case 5:
				int deleteId;
				while (true) {
					System.out.print("Enter ID to Delete: ");
					if (s.hasNextInt()) {
						deleteId = s.nextInt();
						break;
					} else {
						System.out.println("Invalid ID!");
						s.next();
					}
				}
				service.deleteEmployee(deleteId);
				break;

			case 6:
				service.viewFullTime();
				break;

			case 7:
				service.viewInterns();
				break;

			case 8:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 8);
	}
}