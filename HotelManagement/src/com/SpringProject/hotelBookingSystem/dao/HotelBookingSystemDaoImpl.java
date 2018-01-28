package com.SpringProject.hotelBookingSystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SpringProject.hotelBookingSystem.exception.DAOException;
import com.SpringProject.hotelBookingSystem.model.BookingDetail;
import com.SpringProject.hotelBookingSystem.model.Hotels;

/**
 * @author Raja Babu
 *
 */
@Repository
@Transactional
public class HotelBookingSystemDaoImpl implements HotelBookingSystemDao {


	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.dao.HotelBookingSystemDao#getHotels()
	 */
	public List<Hotels> getHotels() throws DAOException {
		List<Hotels> list=new ArrayList<Hotels>();
		try{
		Configuration cfg = new Configuration();

		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Hotels.class);

	    list = cr.list();
		t.commit();
		session.close();
		}
		catch(Exception e){
			throw new DAOException("Exception occured while fetching hotels",e);
		}
		return list;
	}


	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.dao.HotelBookingSystemDao#getHotelNamesByCity(java.lang.String)
	 */
	public List<String> getHotelNamesByCity(String city) {
		Configuration cfg = new Configuration();

		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Query query = session
				.createQuery("select hotelName from Hotels where city = :city ");
		query.setParameter("city", city);
		return query.list();

	}

	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.dao.HotelBookingSystemDao#getHotelsByCity(java.lang.String)
	 */
	public List<Hotels> getHotelsByCity(String city){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// to call hibernate

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Query query = session
				.createQuery("from Hotels where city = :city ORDER BY rate ASC LIMIT 5");
		query.setParameter("city", city);

		return query.list();

	}

	/**
	 * @param hotelName
	 * @return
	 */
	public List<Hotels> getHotelsByName(String hotelName) throws DAOException{
		List<Hotels> list=new ArrayList<Hotels>();
		try{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Hotels.class);
		cr.add(Restrictions.eq("hotelName", hotelName));
		list = cr.list();
		t.commit();
		session.close();
		}catch(Exception e){
			throw new DAOException("Exception occured while fetching hotels",e);
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.SpringProject.hotelBookingSystem.dao.HotelBookingSystemDao#updateHotel(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int updateHotel(String hotelname, String checkindate,
			String checkOutDate, String noOfRooms) throws DAOException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		List<Hotels> hotels = getHotelsByName(hotelname);
		int totalNoOfRooms = hotels.get(0).getNoOfRooms();
		int hotelId = hotels.get(0).getHotelId();

		int bookedRooms = Integer.parseInt(noOfRooms);
		int availableNoOfRooms = totalNoOfRooms - bookedRooms;
		if (availableNoOfRooms <= 0) {
			return 0;
		}
		Query query = session
				.createSQLQuery("update Hotels set checkInDate = :checkindate,"
						+ "checkOutDate = :checkOutDate,"
						+ "noOfRooms = :noOfRooms"
						+ " where hotelName = :hotelname");
		query.setParameter("checkindate", checkindate);
		query.setParameter("checkOutDate", checkOutDate);
		query.setParameter("noOfRooms", availableNoOfRooms);
		query.setParameter("hotelname", hotelname);
		int results = query.executeUpdate();

		BookingDetail bookingDetails = new BookingDetail();
		bookingDetails.setHotelId(hotelId);
		bookingDetails.setUserId(bookedRooms);
		session.persist(bookingDetails);

		int rate = (int) hotels.get(0).getRate();

		session.getTransaction().commit();
		
		return rate;

	}

}
