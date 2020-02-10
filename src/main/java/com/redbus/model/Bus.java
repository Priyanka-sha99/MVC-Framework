package com.redbus.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name="BusDTO")
public class Bus {
	
	@Id
	int busNum;
	@Column
	String source;
	@Column
	String dest;
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column
	Date date;
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	@Column
	Time time;
	@Column
	int totalSeat;
	@Column
	int pricePerTicket;
	@OneToOne(cascade=CascadeType.ALL)
	seatTable st;
	
	
	
	public seatTable getSt() {
		return st;
	}
	public void setSt(seatTable st) {
		this.st = st;
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
	public int getBusNum() {
		return busNum;
	}
	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getPricePerTicket() {
		return pricePerTicket;
	}
	public void setPricePerTicket(int pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}
	

}
