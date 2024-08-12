package com.example.demo.dtos;

public class RegisterUserDto {
    private String email;
    
    private String password;
    
    private String fullName;

	public String getEmail() {
		return email;
	}
	
	
	
	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegisterUserDto(String email, String password,String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public RegisterUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegisterUserDto [email=" + email + ", password=" + password + "]";
	}
    
    
}
