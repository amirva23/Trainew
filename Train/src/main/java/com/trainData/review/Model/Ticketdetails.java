package com.trainData.review.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Ticketdetails {

	@Id
	private  int ticket_no;
	private int seats;
	public int getTicket_no() {
		return ticket_no;
	}
	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	

}
