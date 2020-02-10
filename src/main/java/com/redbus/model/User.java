package com.redbus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userData")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int id;
	@Column
	String username;
	@Column(name="uname")
	String name;
	@Column(name="pass")
	String password;
	@Column(name="email")
	String email;
	@Column(name="contact")
	int num;
	@Column(name="addr")
	String addr;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
