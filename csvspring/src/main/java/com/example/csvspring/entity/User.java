package com.example.csvspring.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String height ;
	private String weight;
	private String adit;
	
	

	public User(long id, String height, String weight,String adit) {
		super();
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.adit= adit;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getAdit() {
		return adit;
	}



	public void setAdit(String adit) {
		this.adit = adit;
	}



	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	public String getWeight() {
		return weight;
	}



	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
	
}
