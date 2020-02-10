package com.redbus.model;

import javax.persistence.*;

@Entity
@Table(name="seatTableDTO")
public class seatTable {
	
	@Id
	int bnum;
	
	@Column
	long seats;
	
	
	
	
	
	
	
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public long getSeats() {
		return seats;
	}
	public void setSeats(long seats) {
		this.seats = seats;
	}

}
