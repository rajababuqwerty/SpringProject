package com.SpringProject.hotelBookingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringProject.hotelBookingSystem.dao.HotelBookingSystemDao;
import com.SpringProject.hotelBookingSystem.exception.DAOException;
import com.SpringProject.hotelBookingSystem.exception.HotelBookingSystemException;
import com.SpringProject.hotelBookingSystem.model.Hotels;

/**
 * @author Raja Babu
 *
 */

@Component
public class HotelBookingSystemServiceImpl implements HotelBookingSystemService {

	@Autowired
	HotelBookingSystemDao hotelBookingSystemDao;

	/**
	 * @return
	 */
	public HotelBookingSystemDao getHotelDao() {
		return hotelBookingSystemDao;
	}

	/**
	 * @param hotelBookingSystemDao
	 */
	public void setHotelDao(HotelBookingSystemDao hotelBookingSystemDao) {
		this.hotelBookingSystemDao = hotelBookingSystemDao;
	}

	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.service.HotelBookingSystemService#getHotels()
	 */
	public List<Hotels> getHotels() throws HotelBookingSystemException {
		List<Hotels> h1 = new ArrayList<Hotels>();

		try {
			h1 = hotelBookingSystemDao.getHotels();
		} catch (DAOException e) {
			throw new HotelBookingSystemException(e.getMessage(), e);
		}
		return h1;
	}

	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.service.HotelBookingSystemService#getHotelNamesByCity(java.lang.String)
	 */
	public List<String> getHotelNamesByCity(String city) throws HotelBookingSystemException { 
		List<String> hotelNames = new ArrayList<String>();
		hotelNames = hotelBookingSystemDao.getHotelNamesByCity(city);
		return hotelNames;
	}

	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.service.HotelBookingSystemService#getHotelsByCity(java.lang.String)
	 */
	public List<Hotels> getHotelsByCity(String city) { // method to get hotel
														// details
		List<Hotels> hotels = new ArrayList<Hotels>();
		hotels = hotelBookingSystemDao.getHotelsByCity(city);
		return hotels;
	}


	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.service.HotelBookingSystemService#updateHotels(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int updateHotels(String hotelname, String checkindate,
			String checkOutDate, String noOfRooms) throws HotelBookingSystemException {

		try {
			return hotelBookingSystemDao.updateHotel(hotelname, checkindate, checkOutDate,
					noOfRooms);
		} catch (DAOException e) {
			throw new HotelBookingSystemException(e.getMessage(), e);
		}

	}

}
