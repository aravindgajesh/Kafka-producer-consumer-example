package com.example.kafka.model;

public class Employee {

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

}
