package com.redbus.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table
public class BookingBus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int bkId;
	
	@Column
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	Date date;
	@Column
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	Time time;
	
	@Column
	long noOfSeat;
	@Column
	String seatNum;
	
	@OneToOne
	User u;
	
	@OneToOne
	Bus b;
	
	

	
	public int getBkId() {
		return bkId;
	}

	public void setBkId(int bkId) {
		this.bkId = bkId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public long getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(long noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Bus getB() {
		return b;
	}

	public void setB(Bus b) {
		this.b = b;
	}
	
	
	
}
