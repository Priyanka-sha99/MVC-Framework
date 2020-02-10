package com.redbus.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatStructure;
import com.redbus.model.seatTable;
@Repository
@Transactional
public class userDao implements userDaoIntrf {
	@Autowired
	SessionFactory sessionFactory;
		
	
	/****************  USER REGISTRATION  *******************/
	@Override
	public String regUser(User uu) {
		int res = validateUsername(uu);
		if(res==0)
		{
		Session session = sessionFactory.getCurrentSession();
		session.save(uu);
		return "success register";
		}
		else
			return "username already exits:";
	}
	
	/****************  USERNAME VALIDATION  *******************/
	@Override
	public int validateUsername(User u) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from User where username= '"+u.getUsername()+"'");
		if((Integer)q.list().size()>0)
			return 1;
		else
			return 0;
	}
	
	
	/****************  USER LOGIN  *******************/
	
	@Override
	public int checkUser(User u) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from User where username= '"+u.getUsername()+"' and password='"+u.getPassword()+"'");
		if(q.list().size()>0)
			return 1;
		else
			return 0;
	}
	
	/**************** TO VIEW USER PROFILE   *******************/

	@Override
	public User viewUser(String nm) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from User where username= '"+nm+"'");
		return (User) q.list().get(0);
	}
	
	
	/**************** SEARCH BUS FROM GIVEN SRC TO DES  *******************/

	@Override
	public List<Bus> searchBus(Bus bb) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from Bus where source='"+bb.getSource()+"' and dest='"+bb.getDest()+"'");
		return q.list();
	}
	
	
	/**************** SELECTED BUS AVAILABLE SEAT  *******************/

	@Override
	public long getAvalbSeat(int busNum) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("select seats from seatTable where bnum="+busNum+"");
		return (Long)q.uniqueResult();
	}
	
	
	/**************** BUS DETAILS OF SELECTED BUS TO BOOK   *******************/
	
	
	@Override
	public Bus viewBusToBook(int bno) {
		
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from Bus where busNum="+bno+"");
		return (Bus) q.list().get(0);
	}
	
	
	
	/**************** TO GET USER ID FROM USERNAME FOR BOOKING  *******************/

	@Override
	public User getuserId(String usrname) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from User where username= '"+usrname+"'");
		return (User) q.list().get(0);
	}
	
	
	
	/****************  GET SEAT NUMBERS FROM SELECTED BUS  *******************/
	
	
	@Override
	public List<seatStructure> seatNUM(int bnum) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from seatStructure where  b_busNum="+bnum+"");
		
		System.out.println("size of list "+q.list().size());
		return (List<seatStructure>)q.list();
	}
	
	/**************** INSERT SEAT NUMBERS FROM SELECTED BY USER FOR BOOKING  *******************/
	@Override
	public void insertSeatNum(seatStructure ss) {
		System.out.println("userID: "+ss.getU().getId());
		Session session = sessionFactory.getCurrentSession();
		session.save(ss);
		
	}
	
	
	/**************** COUNT OF SEATS BOOKED BY USER FROM SEAT STRUCTURE TABLE   *******************/

	@Override
	public long getCOUNTofSeatsBooked(seatStructure s) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("select count(seatval) from seatStructure where u_id="+s.getU().getId()+" and b_busNum="+s.getB().getBusNum()+" ");
		return (Long)q.uniqueResult();
	}

	/***************  GET USER DETAILS TO BOOK      *******************/
	
	@Override
	public User getUserDt(int id) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from User where id="+id+"");
		return (User) q.list().get(0);
	}
	
	
	/****************  MINUS SEATS FROM SEATTABLE WITH COUNT OF BOOKEDSEATS  *******************/
	@Override
	public void updateSeatTable(seatTable st) {
		Session session = sessionFactory.getCurrentSession();
		session.update(st);
		
	}
	
	/**************** INSERT DATA IN DB   *******************/
	@Override
	public void insertBookData(BookingBus b) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(b);
		
		
	}
	
	/**************** VIEW USERS BOOKING   *******************/
	
	@Override
	public List<BookingBus> viewBooking(int id) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from BookingBus where u_id="+id+"");
		return q.list();
	
	}
	
	/***********  VIEW FROM BUS USING BUSNUM ***************/
	@Override
	public Bus viewAllBusDetails(int bnum){
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from Bus where busNum="+bnum+"");
		return (Bus) q.list().get(0);
	
	}

	/***********   FROM BOOKINGBUS TO VIEW ALL BOOKINGS USING BUSNUM ***************/
	
	@Override
	public List<BookingBus> viewBookingBusDetails(int bnum) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q=session.createQuery("from BookingBus where b_busNum="+bnum+"");
		return (List<BookingBus>) q.list();
	}

	

}
