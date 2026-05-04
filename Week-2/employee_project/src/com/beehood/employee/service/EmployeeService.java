package com.beehood.employee.service;

import java.util.ArrayList;
import java.util.List;
import com.beehood.employee.model.Employee;
import com.beehood.employee.model.FullTimeEmployee;
import com.beehood.employee.model.Intern;

public class EmployeeService {

	List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee e) {
		employees.add(e);
	}

	public void viewEmployees() {
		if (employees.isEmpty()) {
			System.out.println("No employees available!");
		} else {
			for (Employee emp : employees) {
				System.out.println(emp);
				System.out.println("-------------------");
			}
		}
	}

	public void searchEmployee(int searchId) {
		boolean found = false;
		for (Employee emp : employees) {
			if (emp.getId() == searchId) {
				System.out.println("Employee Found!");
				System.out.println(emp);
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Employee not found!");
	}

	public void deleteEmployee(int deleteId) {
		boolean found = false;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId() == deleteId) {
				employees.remove(i);
				System.out.println("Employee Deleted Successfully!");
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Employee not found!");
	}

	public void viewFullTime() {
		boolean found = false;
		for (Employee emp : employees) {
			if (emp instanceof FullTimeEmployee) {
				System.out.println(emp);
				System.out.println("-------------------");
				found = true;
			}
		}
		if (!found)
			System.out.println("No full time employees found!");
	}

	public void viewInterns() {
		boolean found = false;
		for (Employee emp : employees) {
			if (emp instanceof Intern) {
				System.out.println(emp);
				System.out.println("-------------------");
				found = true;
			}
		}
		if (!found)
			System.out.println("No interns found!");
	}
}