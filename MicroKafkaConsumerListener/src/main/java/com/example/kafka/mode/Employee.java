package com.example.kafka.mode;

public class Employee {

	public Employee() {
		
	}

	private String name;
	private String department;
	private String technology;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Employee(String name, String department, String technology) {
		super();
		this.name = name;
		this.department = department;
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", technology=" + technology + "]";
	}

}
