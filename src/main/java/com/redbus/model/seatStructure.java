package com.redbus.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table
public class seatStructure {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sid;
	@Column
	long seatval;
	@OneToOne
	Bus b;
	@OneToOne
	User u;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public long getSeatval() {
		return seatval;
	}
	public void setSeatval(long seatval) {
		this.seatval = seatval;
	}
	
	public Bus getB() {
		return b;
	}
	public void setB(Bus b) {
		this.b = b;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
}
