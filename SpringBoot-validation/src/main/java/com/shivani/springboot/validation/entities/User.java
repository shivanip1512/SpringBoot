package com.shivani.springboot.validation.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotBlank(message = "User name cannot be empty")
	@Size(min = 3, max = 15, message = "User name must be between 3 - 15 characters")
	private String userName;

	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Please enter valid Email-ID")
	private String email;

	@AssertTrue(message = "Please agree to Terms and Conditions")
	private boolean agreed;

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + "]";
	}
}
