package com.welleys.stu.basic.java.a01.classdefinition;

import java.util.logging.Logger;

public class Person {

	private Logger log = Logger.getLogger(getClass().getName());

	// private String name;
	private String firstName;
	private String lastName;
	private int age;
	private int height;
	private int weight;
	private String eyeColor;

	private String gender;

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, int age, int height, int weight, String eyeColor, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.eyeColor = eyeColor;
		this.gender = gender;
	}
	
	public String getFullName() {
		return getFirstName().concat(" ").concat(getLastName());
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", eyeColor=" + eyeColor + ", gender=" + gender + "]";
	}

	// @Override
	// public String toString() {
	// return "Person [name=" + name + ", age=" + age + ", height=" + height + ",
	// weight=" + weight + ", eyeColor="
	// + eyeColor + ", gender=" + gender + "]";
	// }

}
