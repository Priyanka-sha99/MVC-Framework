package com.redbus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbus.dao.userDao;
import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatStructure;
import com.redbus.model.seatTable;
@Service
public class userServices implements userServicesIntrf{
@Autowired
userDao userdao;
	@Override
	public Bus viewBusToBook(int bno) {
		// TODO Auto-generated method stub
		return userdao.viewBusToBook(bno);
	}

	@Override
	public User getuserId(String name) {
		// TODO Auto-generated method stub
		return userdao.getuserId(name);
	}

	@Override
	public User viewUser(String nm) {
		// TODO Auto-generated method stub
		return userdao.viewUser(nm);
	}

	

	@Override
	public List<Bus> searchBus(Bus bb) {
		// TODO Auto-generated method stub
		return userdao.searchBus(bb);
	}

	@Override
	public long getAvalbSeat(int busNum) {
		// TODO Auto-generated method stub
		return userdao.getAvalbSeat(busNum);
	}

	

	@Override
	public String regUser(User uu) {
		// TODO Auto-generated method stub
		return userdao.regUser(uu);
	}

	@Override
	public int checkUser(User u) {
		// TODO Auto-generated method stub
		return userdao.checkUser(u);
	}

	

	@Override
	public List<BookingBus> viewBooking(int id) {
		// TODO Auto-generated method stub
		return userdao.viewBooking(id);
	}

	@Override
	public long getCOUNTofSeatsBooked(seatStructure s) {
		// TODO Auto-generated method stub
		return userdao.getCOUNTofSeatsBooked(s);
	}

	

	@Override
	public List<seatStructure> seatNUM(int s) {
		// TODO Auto-generated method stub
		return userdao.seatNUM(s);
	}

	@Override
	public void insertBookData(BookingBus b) {
		// TODO Auto-generated method stub
		userdao.insertBookData(b);
	}

	@Override
	public void updateSeatTable(seatTable st) {
		// TODO Auto-generated method stub
		 userdao.updateSeatTable(st);
	}

	

	@Override
	public void insertSeatNum(seatStructure ss) {
		// TODO Auto-generated method stub
		userdao.insertSeatNum(ss);
	}

	
	@Override
	public User getUserDt(int id) {
		// TODO Auto-generated method stub
		return userdao.getUserDt(id);
	}

	

	
	@Override
	public int validateUsername(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bus viewAllBusDetails(int bnum) {
		
		return userdao.viewAllBusDetails(bnum);
	}

	@Override
	public List<BookingBus> viewBookingBusDetails(int bnum) {
		// TODO Auto-generated method stub
		return userdao.viewBookingBusDetails(bnum);
	}

}
