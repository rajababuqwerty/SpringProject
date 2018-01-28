package com.SpringProject.hotelBookingSystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SpringProject.hotelBookingSystem.exception.HotelBookingSystemException;
import com.SpringProject.hotelBookingSystem.model.Hotels;
import com.SpringProject.hotelBookingSystem.service.HotelBookingSystemService;

/**
 * @author Raja Babu
 *
 */
@Controller
public class HotelBookingSystemController {

	@Autowired
	private HotelBookingSystemService hotelBookingSystemService;

	public HotelBookingSystemService gethotelService() {
		return hotelBookingSystemService;
	}

	public void sethotelService(HotelBookingSystemService hotelBookingSystemService) {
		this.hotelBookingSystemService = hotelBookingSystemService;
	}

	/**
	 * method fetches the list of cities from Database
	 * 
	 * @param hotel
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/book.control", method = RequestMethod.GET)
	public ModelAndView getHotels(@ModelAttribute("hotel") Hotels hotel,
			HttpSession session) {
		List<Hotels> hotelDetails = new ArrayList<Hotels>();
		try {
			hotelDetails = hotelBookingSystemService.getHotels();
		} catch (HotelBookingSystemException e) {
			session.setAttribute("error", "Unable to get the List Of hotels");
		}
		List<String> cities = new ArrayList<String>();
		String city = new String();
		for (Hotels hotels : hotelDetails) {
			if (!city.contains(hotels.getCity())) {
				city = hotels.getCity();
				cities.add(city);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotel", cities);
		mv.setViewName("search");
		return mv;
	}

	/**
	 * @param hotel
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/lowPricedHotels.control", method = RequestMethod.GET)
	public ModelAndView getCities(@ModelAttribute("hotel") Hotels hotel,
			HttpSession session) {
		List<Hotels> hotelDetails = new ArrayList<Hotels>();
		try {
			hotelDetails = hotelBookingSystemService.getHotels();
		} catch (HotelBookingSystemException e) {
			session.setAttribute("error", "Unable to get the List Of hotels");
		}
		List<String> cities = new ArrayList<String>();
		String city = new String();
		for (Hotels hotels : hotelDetails) {
			if (!city.contains(hotels.getCity())) {
				city = hotels.getCity();

				cities.add(city);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotel", cities);
		mv.setViewName("lowestPricedHotels");
		return mv;

	}

	/**
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/fetchHotelName", method = RequestMethod.GET)
	public @ResponseBody String GetName(
			@RequestParam(value = "credit", required = true) String city) {
		List<String> hotelnames = new ArrayList<String>();
		try {
			hotelnames = hotelBookingSystemService.getHotelNamesByCity(city);
		} catch (HotelBookingSystemException e) {
			e.printStackTrace();
		}
		String s = "<select id=\"hotel\" name=\"hotelName\" >";
		for (String sa : hotelnames) {
			s += "<option value=\"" + sa + "\">" + sa + "</option>";
		}
		s += "</select>";
		return s;
	}

	/**
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/lowPricedHotel", method = RequestMethod.GET)
	public @ResponseBody String lowPricedHotels(
			@RequestParam(value = "credit", required = true) String city) {

		List<Hotels> hotelnames = new ArrayList<Hotels>();
		try {
			hotelnames = hotelBookingSystemService.getHotelsByCity(city);
		} catch (HotelBookingSystemException e) {
			e.printStackTrace();
		}

		String s = "<table border=2 cellpadding=4 cellspacing=4> <tr><th>Hotel Id</th><th>Hotel Name</th><th>City</th><th>Check-In-Date</th><th>Check-Out-Date</th><th>No Of Rooms</th><th>Rate</th></tr>";
		for (Hotels sa : hotelnames) {
			s += "<tr><td align=center>" + sa.getHotelId() + "</td><td align=center>"
					+ sa.getHotelName() + "</td><td align=center>" + sa.getCity()
					+ "</td><td align=center>" + sa.getCheckInDate() + "</td><td align=center>"
					+ sa.getCheckOutDate() + "</td><td align=center>" + sa.getNoOfRooms()
					+ "</td><td align=center>" + sa.getRate() + "</tr>";
		}
		s += "</table>";

		return s;
	}

	/**
	 * @param hotel
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.control", method = RequestMethod.GET)
	public ModelAndView bookRoom(@ModelAttribute("userForm") Hotels hotel,
			ModelMap model, HttpServletRequest request) {
		String hotelname = request.getParameter("hotelName");
		String checkindate = request.getParameter("checkInDate");
		String checkOutDate = request.getParameter("checkOutDate");
		String noOfRooms = request.getParameter("noOfRooms");

		int rate = 0;
		try {
			rate = hotelBookingSystemService.updateHotels(hotelname, checkindate,
					checkOutDate, noOfRooms);
		} catch (HotelBookingSystemException e) {
			e.printStackTrace();
		}
		double randNumber = Math.random();
		int randomNumber = (int) (randNumber * 100);

		String str = Integer.toString(rate);
		String second = Integer.toString(randomNumber);

		List<String> rateId = new ArrayList<String>();
		rateId.add(str);
		rateId.add(second);

		ModelAndView mv = new ModelAndView();
		if (rate == 0) {
			mv.addObject("hotel", rateId);
			mv.setViewName("error");
			return mv;

		} else
			mv.addObject("hotel", rateId);
		mv.setViewName("success");
		return mv;

	}
}
