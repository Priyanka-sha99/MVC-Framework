package com.redbus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbus.dao.adminDao;
import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatTable;
@Service
public class adminServices implements adminServicesIntrf {
@Autowired
adminDao admindao;

	@Override
	public void addbus(Bus b) {
		admindao.addbus(b);
		
	}

	@Override
	public void deletebus(Bus b) {
		admindao.deletebus(b);
		
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return admindao.viewAllUsers();
	}

	@Override
	public List<BookingBus> viewAllBooking() {
		// TODO Auto-generated method stub
		return admindao.viewAllBooking();
	}

	@Override
	public void updateBus(Bus b) {
		admindao.updateBus(b);
		
	}



	

}
