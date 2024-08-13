package com.example.demo.model;

import org.hibernate.annotations.DialectOverride.Version;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class CustomerModel {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;

@JsonProperty("first_name")
private String firstName;


@JsonProperty("last_name")
private String lastName;

private String street;
private String address;
private String city;
private String state;
private String email;
private String phone;
private String uuid;

@Version(major = 0)
private Long version; 

public CustomerModel() {
	 
	// TODO Auto-generated constructor stub
}
public CustomerModel(Long id, String firstName, String lastName, String street, String address, String city,
		String state, String email, String phone) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.street = street;
	this.address = address;
	this.city = city;
	this.state = state;
	this.email = email;
	this.phone = phone;
}


public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
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
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
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


public Long getVersion() {
	return version;
}
public void setVersion(Long version) {
	this.version = version;
}
@Override
public String toString() {
	return "CustomerModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
			+ ", address=" + address + ", city=" + city + ", state=" + state + ", email=" + email + ", phone=" + phone
			+ ", uuid=" + uuid + ", version=" + version + "]";
}
 


}
