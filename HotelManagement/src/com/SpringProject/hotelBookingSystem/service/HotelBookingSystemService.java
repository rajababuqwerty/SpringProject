package com.SpringProject.hotelBookingSystem.service;

import java.util.List;

import com.SpringProject.hotelBookingSystem.exception.HotelBookingSystemException;
import com.SpringProject.hotelBookingSystem.model.Hotels;

/**
 * @author Raja Babu
 *
 */
public interface HotelBookingSystemService {

	/**Service Interface method to get List of hotels
	 * @return
	 * @throws HotelBookingSystemException
	 */
	
	public List<Hotels> getHotels()throws HotelBookingSystemException;
	/**Service Interface method to get List of Hotel Names based on city
	 * @param city
	 * @return
	 * @throws HotelBookingSystemException
	 */
	public List<String> getHotelNamesByCity(String city)throws HotelBookingSystemException;
	/**Service Interface method to get List of Hotels based on city
	 * @param city
	 * @return
	 * @throws HotelBookingSystemException
	 */
	public List<Hotels> getHotelsByCity(String city)throws HotelBookingSystemException;
	/**Service Interface method to update the hotels
	 * @param a
	 * @throws HotelBookingSystemException
	 */
	public int updateHotels(String hotelname, String checkindate,String checkOutDate,String noOfRooms)throws HotelBookingSystemException;
	
}
