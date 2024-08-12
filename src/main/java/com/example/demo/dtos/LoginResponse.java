package com.example.demo.dtos;

public class LoginResponse {
	private String token;

    private long expiresIn;

    public  String getToken() {
        return token;
    }

	public long getExpiresIn() {
		return expiresIn;
	}

	public LoginResponse setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
		return this;
	}

	public  LoginResponse setToken(String token) {
		this.token = token;
		return this;
	}

	public LoginResponse(String token, long expiresIn) {
		super();
		this.token = token;
		this.expiresIn = expiresIn;
	}

	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", expiresIn=" + expiresIn + "]";
	}
    
}
