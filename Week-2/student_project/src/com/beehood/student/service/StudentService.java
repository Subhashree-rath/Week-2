package com.beehood.student.service;

import java.util.ArrayList;
import java.util.List;
import com.beehood.student.model.Student;

public class StudentService {

	List<Student> students = new ArrayList<>();

	public void addStudent(Student s) {
		students.add(s);
		System.out.println("Student Added Successfully!");
	}

	public void viewStudents() {
		if (students.isEmpty()) {
			System.out.println("No students available!");
		} else {
			for (Student st : students) {
				System.out.println(st);
			}
		}
	}

	public void searchStudent(int searchId) {
		boolean found = false;
		for (Student st : students) {
			if (st.getId() == searchId) {
				System.out.println("Student Found!");
				System.out.println(st);
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Student not found!");
	}

	public void deleteStudent(int deleteId) {
		boolean found = false;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == deleteId) {
				students.remove(i);
				System.out.println("Student Deleted Successfully!");
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Student not found!");
	}
}