package com.trainData.review.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Traindetails {

	@Id
	  private int  train_num;
	private String name;
	private String source;
	public List<Ticketdetails> getTicket() {
		return ticket;
	}
	public void setTicket(List<Ticketdetails> ticket) {
		this.ticket = ticket;
	}
	private String destination;
	private int cost;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Ticketdetails> ticket;
	public int getTrain_num() {
		return train_num;
	}
	public void setTrain_num(int train_num) {
		this.train_num = train_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
