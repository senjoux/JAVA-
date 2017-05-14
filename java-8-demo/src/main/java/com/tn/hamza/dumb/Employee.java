package com.tn.hamza.dumb;

import java.util.Arrays;
import java.util.List;

public class Employee {

	private String name;
	private Gender gender;
	private int age;

	public Employee() {
	}

	
	public Employee(String name, Gender gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}


	public static List<Employee> createEmployees() {
		return Arrays.asList(
				new Employee("Salah", Gender.MALE, 19),
				new Employee("Emma", Gender.FEMALE, 41),
				new Employee("Katia", Gender.FEMALE, 19),
				new Employee("Mourad", Gender.MALE, 34),
				new Employee("Emma", Gender.FEMALE, 24),
				new Employee("Paula", Gender.FEMALE, 41),
				new Employee("Salah", Gender.MALE, 22)
				);
		
	}
	public enum Gender {
		FEMALE, MALE
	}

}
