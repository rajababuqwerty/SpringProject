package com.SpringProject.hotelBookingSystem.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raja Babu
 * creating hotel entity and table in database
 */
@Entity
@Table(name= "hotels")
public class Hotels { 
	@Id
	@GeneratedValue
	int hotelId;
String hotelName;
String city;
String checkInDate;
String checkOutDate;
int noOfRooms;
int rate;
public int getHotelId() {
	return hotelId;
}


public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}


public String getHotelName() {
	return hotelName;
}



public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}





public String getCheckInDate() {
	return checkInDate;
}


public void setCheckInDate(String checkInDate) {
	this.checkInDate = checkInDate;
}


public String getCheckOutDate() {
	return checkOutDate;
}


public void setCheckOutDate(String checkOutDate) {
	this.checkOutDate = checkOutDate;
}


public int getNoOfRooms() {
	return noOfRooms;
}


public void setNoOfRooms(int noOfRooms) {
	this.noOfRooms = noOfRooms;
}


public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public double getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}


}