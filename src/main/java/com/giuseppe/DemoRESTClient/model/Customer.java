package com.giuseppe.DemoRESTClient.model;

public class Customer {

	private long id;
	private String firstName;
	private String lastName;
	private int age;

	public Customer() {

	}

	public Customer(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age;
	}

}
