package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerServices.AuthenticationService;
import com.example.demo.customerServices.JwtService;
import com.example.demo.dtos.LoginResponse;
import com.example.demo.dtos.LoginUserDto;
import com.example.demo.dtos.RegisterUserDto;
import com.example.demo.model.User;

@RestController
@RequestMapping("/api/customers/public")
 
public class AuthenticationController {
	  
	 private final JwtService jwtService;
	    
	    private final AuthenticationService authenticationService;

	    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
	        this.jwtService = jwtService;
	        this.authenticationService = authenticationService;
	    }

	    @PostMapping("/signup")
	    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
	        User registeredUser = authenticationService.signup(registerUserDto);

	        return ResponseEntity.ok(registeredUser);
	    }
	 
	    @PostMapping("/login")
	    public ResponseEntity<?> authenticate(@RequestBody LoginUserDto loginUserDto) {

	        
	        try {
		        User authenticatedUser = authenticationService.authenticate(loginUserDto);

		        String jwtToken = jwtService.generateToken(authenticatedUser);
		       
		        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

		        return ResponseEntity.ok(loginResponse);
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
			}
	    }
}
