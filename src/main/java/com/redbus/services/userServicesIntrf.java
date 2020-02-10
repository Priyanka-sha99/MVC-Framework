package com.redbus.services;

import java.util.List;

import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatStructure;
import com.redbus.model.seatTable;

public interface userServicesIntrf {
	String regUser(User uu);
	
	int validateUsername(User u);
	
	int checkUser(User u);
	
	User viewUser(String nm);
	
	List<Bus> searchBus(Bus bb);
	
	long getAvalbSeat(int busNum);
	
	Bus viewBusToBook(int bno);
	
	User getuserId(String name);
	
	List<seatStructure> seatNUM(int bnum);
	
	void insertSeatNum(seatStructure ss) ;
	
	long getCOUNTofSeatsBooked(seatStructure s);
	
	User getUserDt(int id);
	
	void updateSeatTable(seatTable st);
	
	void insertBookData(BookingBus b);
	
	List<BookingBus> viewBooking(int id);
	
	Bus viewAllBusDetails(int bnum);
	
	List<BookingBus> viewBookingBusDetails(int bnum);
}
