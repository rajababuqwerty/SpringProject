package com.SpringProject.hotelBookingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


	/**
	 * @author Raja Babu
	 *
	 */
	@Entity
	@Table(name= "bookingDetails")
	public class BookingDetail { //creating hotel entity and table in database
		@Id
		@GeneratedValue
		int bookingId;
	int hotelId;
	int userId;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
