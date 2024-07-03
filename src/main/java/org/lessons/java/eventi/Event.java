package org.lessons.java.eventi;

import java.util.Calendar;

public class Event {
	
	//Class fields definition
	
	private String title;
	private Calendar eventDate;
	private int seatsNumber;
	private int eventReservation = 0;
	private Calendar currentDate = Calendar.getInstance();
	
	
	//Constructor method
	
	public Event(String title, Calendar eventDate , int seatsNumber) {
		
		this.title = title;
		
		if(eventDate.after(currentDate)) {
			
			this.eventDate = eventDate;	
			
		}else {
			
			System.out.println("The date entered is already passed. Please enter a valid date");
			
		}
		
		if(seatsNumber > 0 ) {
			
			this.seatsNumber = seatsNumber;	
			
		}else {
			
			System.out.println("The number of seats for the event must be greater then 0. Please enter a valid number of seats");
			
		}
		
		
	}
	
	//Getters and Setters


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Calendar getEventDate() {
		return eventDate;
	}


	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}


	public int getSeatsNumber() {
		return seatsNumber;
	}


	public int getEventReservation() {
		return eventReservation;
	}
	
	
	//Method used to reserve a seats at the event
	
	public void reserveSeat() {
		
		if(eventDate.before(currentDate)) {
			
			System.out.println("The event is already passed");
			
		}else if(eventReservation == seatsNumber){
			
			System.out.println("The event is soldout");
			
		}else {
			
			this.eventReservation++;
			
		}
	}
	
	//Method used to delete a reservation
	
	public void cancelReservation() {
		
		if(eventDate.before(currentDate)) {
			
			System.out.println("The event is already passed");
			
		}else if(eventReservation == 0){
			
			System.out.println("There are no reservetion to cancel for this event");
			
		}else {
			
			this.eventReservation--;
			
		}
		
	}
	
	//Override of the toString() method to get event event information formatted into a string
	
	public String toString() {
		
		
		String formattedDate = EventManagerUtil.dateFormatter(eventDate);
		
		return (formattedDate + " - " + this.title);
		
		
	}
	
	
	//Method used to calculate the difference between total seats and reserved seats
	
	public int availableSeats() {
		
		int availableSeats =  this.seatsNumber - this.eventReservation;
		
		return availableSeats;
		
	}
	
	
	

}