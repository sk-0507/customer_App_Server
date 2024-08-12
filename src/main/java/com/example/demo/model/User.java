package com.example.demo.model;

 
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Users")
@Entity

public  class User implements UserDetails{
 

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String email;

private String password;

private String FullName;
public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(Long id, String email, String password,String FullName) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.FullName = FullName;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
}

@Override
public String getUsername() {
    return email;
}

@Override
public boolean isAccountNonExpired() {
    return true;
}

@Override
public boolean isAccountNonLocked() {
    return true;
}

@Override
public boolean isCredentialsNonExpired() {
    return true;
}

@Override
public boolean isEnabled() {
    return true;
}

public String getFullName() {
	return FullName;
}

public void setFullName(String fullName) {
	FullName = fullName;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
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

@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
}


}
