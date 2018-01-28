package com.SpringProject.hotelBookingSystem.exception;

/**
 * @author Raja Babu 
 *
 */
public class HotelBookingSystemException extends DAOException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public HotelBookingSystemException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public HotelBookingSystemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public HotelBookingSystemException(Throwable ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public HotelBookingSystemException(String message, Throwable ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public HotelBookingSystemException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
