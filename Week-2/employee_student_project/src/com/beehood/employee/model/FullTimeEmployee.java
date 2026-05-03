package com.beehood.employee.model;

public class FullTimeEmployee extends Employee {

	private double salary;

	public FullTimeEmployee(int id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public double calculateSalary() {
		return salary;
	}
}