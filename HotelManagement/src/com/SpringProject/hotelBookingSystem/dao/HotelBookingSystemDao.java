package com.SpringProject.hotelBookingSystem.dao;

import java.util.List;

import com.SpringProject.hotelBookingSystem.exception.DAOException;
import com.SpringProject.hotelBookingSystem.model.Hotels;

/**
 * @author Raja Babu
 *
 */
public interface HotelBookingSystemDao {
	/**
	 * This DAO interface method to get List of Hotels
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Hotels> getHotels() throws DAOException;

	/**
	 * This DAO interface method to get List of hotel names belonging to
	 * particular city
	 * 
	 * @param city
	
	 */
	public List<String> getHotelNamesByCity(String city);

	/**
	 * This DAO interface method to update hotel details
	 * 
	 * @param hotelname
	 *            ,checkindate,checkOutDate,noOfRooms
	 * @throws DAOException
	 */
	public int updateHotel(String hotelname, String checkindate,
			String checkOutDate, String noOfRooms) throws DAOException;

	/**
	 * This DAO interface method toget List of hotels belonging to particular
	 * city
	 * 
	 * @param city
	 */
	public List<Hotels> getHotelsByCity(String city);

	/**
	 * This DAO interface method to get List of hotels
	 * 
	 * @param hotelName
	 * @throws DAOException
	 */
	public List<Hotels> getHotelsByName(String hotelName) throws DAOException;
}
