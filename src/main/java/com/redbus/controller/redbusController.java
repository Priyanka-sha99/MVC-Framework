package com.redbus.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redbus.mail.SendMail;
import com.redbus.model.BookingBus;
import com.redbus.model.Bus;
import com.redbus.model.User;
import com.redbus.model.seatStructure;
import com.redbus.model.seatTable;
import com.redbus.services.adminServicesIntrf;
import com.redbus.services.userServicesIntrf;

@RestController
public class redbusController {
@Autowired
userServicesIntrf userServices;
@Autowired
adminServicesIntrf adminServices;


				/**************** USER OPERATIONS *****************/
//add user
@RequestMapping(method=RequestMethod.POST,value="/registerUser")
public String registerUser(@RequestBody User s)
{
	System.out.println(s.getNum()+"  ");
	return userServices.regUser(s);
	
	
}
//login user
@RequestMapping(method=RequestMethod.POST,value="/loginUser")
public String loginUser(@RequestBody User s)
{
	int i=userServices.checkUser(s);
	if(i==1)
		return "login successful!";
	else
		return "userName OR password is incorrect!";
}

//view user profile
@RequestMapping(method=RequestMethod.GET,value="/viewSeluser/{username}")
public User getSelData(@PathVariable("username") String username)
{
	System.out.println(username+ "Username: ");
   return userServices.viewUser(username);
}

//view bus to book from src to des
@RequestMapping(method=RequestMethod.GET,value="/viewSelBusforUser/{source}/{dest}")
public List<Bus> getBusData(@ModelAttribute Bus b)
{

		return userServices.searchBus(b);
}

//available sears of selected bus
@RequestMapping(method=RequestMethod.GET,value="/getAvalSeatOfSelBus/{bnum}")
public String getAvalSeatOfSelBus(@PathVariable("bnum") int bnum)
{
   long seats= userServices.getAvalbSeat(bnum);
   return "Available seats of selBus: " +seats;
}

//bus details to user of selected bus
@RequestMapping(method=RequestMethod.GET,value="/getBusDetailsOfSelBus/{bnum}")
public Bus getBusDetailsOfSelBus(@PathVariable("bnum") int bnum)
{
	//
	
   return userServices.viewBusToBook(bnum);
}

//get user id from username
@RequestMapping(method=RequestMethod.GET,value="/getSelUserId/{username}")
public String getSelUserId(@PathVariable("username") String username)
{
	//System.out.println(username+ "Username: ");
   User u= userServices.getuserId(username);
   return "ID of selected UserName: "+u.getId();
}

//view seats num booked
@RequestMapping(method=RequestMethod.GET,value="/BookedSeatNumOfSelBus/{bnum}")
public List<Long> BookedSeatNumOfSelBus(@PathVariable("bnum") int bnum)
{
	//System.out.println(s.getBnum());
	List<seatStructure> list=userServices.seatNUM(bnum);
	List<Long> seatVal = new ArrayList<Long>();
	
 for(seatStructure ss:list)
 {
	 
	 seatVal.add(ss.getSeatval());
 }
return seatVal;
}

//insert in seatStructure seat num
@RequestMapping(method=RequestMethod.POST,value="/insertSeatsinSeatStructure")
public String insertSeatsinSeatStructure(@RequestBody seatStructure s)
{
	userServices.insertSeatNum(s);
	return "insert Successfully..";
	
	
}

//get the count of seats selected by user from seatStructure inserting uid and busNum
@RequestMapping(method=RequestMethod.GET,value="/countOfSeatsSelByUser")
public long countOfSeatsSelByUser(@RequestBody seatStructure s )
{
	
	System.out.println("sid "+s.getU().getId()+ "Bnum " +s);
   return userServices.getCOUNTofSeatsBooked(s);
}

//get number of seats from seatTable by bnum
@RequestMapping(method=RequestMethod.GET,value="/getSeatsfromstTable/{bnum}")
public String getSeatsfromstTable(@PathVariable("bnum") int bnum)
{
	
	long seats= userServices.getAvalbSeat(bnum);
   return "seats from SeatTable: "+seats;
}

//update seatTable by minus above to methods result
@RequestMapping(method=RequestMethod.PUT,value="/UpdateSeatTable")
public String UpdateSeatTable(@RequestBody seatTable s)
{
	
	userServices.updateSeatTable(s);
	return "updated successfully!";
}

//insert booking in db
@RequestMapping(method=RequestMethod.POST,value="/insertbookingDatainDB")
public String insertbookingDatainDB(@RequestBody BookingBus b)
{
	
	System.out.println("getSeatsNumbers: "+b.getSeatNum()+"  ------ "+b.getNoOfSeat());
	userServices.insertBookData(b);
	return "successfulBooking....";
	
}

//view booking of particular user by userID
@RequestMapping(method=RequestMethod.GET,value="/viewUsersBooking/{id}")
public List<BookingBus> viewUsersBooking(@PathVariable("id") int id)
{
	List<BookingBus> b = userServices.viewBooking(id);
	System.out.println("BookBus: "+b.size());
	
	 return b;
	
	
}

//to send mail of booking confirmation
@RequestMapping(method=RequestMethod.GET,value="/sendMailtToUser/{id}")
public void sendMailtToUser(@PathVariable("id") int id )
{
	User u=userServices.getUserDt(id);
	System.out.println("sid "+u.getId()+ "Bnum " +u.getEmail());
	 SendMail.send(u.getEmail(), "Confirmation mail for your booking", "BookingSuccess", "serverbusapp@gmail.com", "busapp123");
  
}

//to view bus deTAILS by bus num
@RequestMapping(method=RequestMethod.GET,value="/viewBusDetails/{bnum}")
public Bus viewBusDetails(@PathVariable("bnum") int bnum)
{
	return userServices.viewAllBusDetails(bnum);
	
}

//to view all bookingBus details by busNum
@RequestMapping(method=RequestMethod.GET,value="/viewBookingBusDetails/{bnum}")
public List<BookingBus> viewBookingBusDetails(@PathVariable("bnum") int bnum)
{
	return userServices.viewBookingBusDetails(bnum);
	
}

					/**********ADMIN OPERATIONS**********/

//to add bus
@RequestMapping(method=RequestMethod.POST,value="/addbusAdmin")
public void addbusnSeatAdmin(@RequestBody Bus s)
{
	System.out.println(s.getDate()+" time:  " +s.getTime());
	 adminServices.addbus(s);
	 System.out.println("Bus added success");
	 
	
}


//view all users
@RequestMapping(method=RequestMethod.GET,value="/viewAllUser")
public List<User> viewAllUser()
{
   return adminServices.viewAllUsers();
}

//view all bookings
@RequestMapping(method=RequestMethod.GET,value="/viewAllBooking")
public List<BookingBus> viewAllBooking()
{
   return adminServices.viewAllBooking();
}

//to delete bus from db
@RequestMapping(method=RequestMethod.DELETE,value="/deleteBus/{busNum}")
public String deleteBus(@RequestBody Bus b)
{
	adminServices.deletebus(b);
   return "Bus Delete Success..." ;
}

//to update bus
@RequestMapping(method=RequestMethod.PUT,value="/UpdateBus")
public String UpdateBus(@RequestBody Bus b)
{
	
	adminServices.updateBus(b);
	return "updated successfully!";
}

}