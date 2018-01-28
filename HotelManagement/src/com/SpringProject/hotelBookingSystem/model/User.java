package com.SpringProject.hotelBookingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raja Babu
 * creating login entity and table in database
 */
@Entity
@Table(name= "user")
public class User { 
	@Id
	@GeneratedValue
	int userId;
	String userName;
	public int getUserid() {
		return userId;
	}
	public void setUserid(int userid) {
		this.userId = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}