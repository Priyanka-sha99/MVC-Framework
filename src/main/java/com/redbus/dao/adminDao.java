package com.redbus.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatTable;
@Repository
@Transactional
public class adminDao implements adminDaoIntrf{
@Autowired
SessionFactory sessionFactory;;
	
	/********************** ADD BUS IN BUS DB    ****************************/
	@Override
	public void addbus(Bus b) {
		Session session = sessionFactory.getCurrentSession();
		session.save(b);
		
	}
	
	/************************TO DELETE BUS**************************/
	@Override
	public void deletebus(Bus b) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(b);
		
	}
	
	
	/*********************** TO VIEW ALL USERS  ***************************/

	@Override
	public List<User> viewAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from User");
		return q.list();
	}

	/*********************** TO VIEW ALL Bus BOOKINGS  ***************************/
	
	@Override
	public List<BookingBus> viewAllBooking() {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from BookingBus");
		return q.list();
	}

	/*********************** TO UpdAte BUS  ***************************/
	
	@Override
	public void updateBus(Bus b) {
		Session session = sessionFactory.getCurrentSession();
		session.update(b);
		
	}


	
	

	
}
