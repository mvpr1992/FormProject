package com.example.FormProject.model;


public class Form {

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	//Adding the mobile as part of release 2
	private String mobile;
	
	public Form() {
	
	} 
    
    public Form(int id, String firstName,String lastName,String address, String mobile) {
       
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.address = address;
    	this.mobile = mobile;
    }
    
    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
    
    
    
    
}
