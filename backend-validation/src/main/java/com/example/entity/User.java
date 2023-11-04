package com.example.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

	@NotNull
	private String username;

	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password Should formately")
	private String pass;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Name should contain only alphabetic characters")
	private String name;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Invalid country name format")
	private String country;

	@NotNull
	@Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email format")
	private String email;

	@NotNull
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number format. Please enter a 10-digit number.")
	private String phone;

	@NotNull
	@Min(value = 0, message = "Age should not be less than 0")
	@Max(value = 150, message = "Age should not be greater than 150")
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
