package com.cognizant.spring_learn;

public class Country {
	private String name;
	private String code;
	
	public Country() {
		System.out.println("Inside Country Constructor.");
	}
	
	public String getCode() {
		System.out.println("Inside getCode");
		return code;
	}
	 public void setCode(String code) {
	        System.out.println("Inside setCode()");
	        this.code = code;
	    }
	 public String getName() {
	        System.out.println("Inside getName()");
	        return name;
	    }
	 public void setName(String name) {
	        System.out.println("Inside setName()");
	        this.name = name;
	    }
	 
	 public String toString() {
		    return "Country [code=" + code + ", name=" + name + "]";
		}
	
}
