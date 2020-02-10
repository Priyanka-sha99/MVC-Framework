package com.redbus.dao;

import java.util.List;

import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatTable;

public interface adminDaoIntrf {

	void addbus(Bus b);
	
	void deletebus(Bus b);
	
	List<User> viewAllUsers();
	
	List<BookingBus> viewAllBooking();
	
	void updateBus(Bus b);
}
