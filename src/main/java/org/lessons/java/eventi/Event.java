package org.lessons.java.eventi;

import java.util.Calendar;
import java.util.Scanner;

public class Event {
	
	//Class fields definition
	
	private String title;
	private Calendar eventDate;
	private int seatsNumber;
	private int eventReservation = 0;
	private Calendar currentDate = Calendar.getInstance();
	
	Scanner scanner = new Scanner(System.in);
	
	
	//Constructor method
	
	public Event(String title, Calendar eventDate , int seatsNumber) {
		
		this.title = title;
		
		while(this.eventDate == null) {
			
			if(eventDate.after(currentDate)) {
				
				this.eventDate = (Calendar) eventDate.clone();	
				
			}else {
				
				System.out.println("The date entered is already passed. Please enter a valid date");
				eventDate = EventManagerUtil.populateDate();
				
			}
		
		}
		
		while(this.seatsNumber <= 0) {
		
			if(seatsNumber > 0 ) {
				
				this.seatsNumber = seatsNumber;	
				
			}else {
				
				System.out.println("The number of seats for the event must be greater then 0. Please enter a valid number of seats");
				setSeatsNumber(scanner.nextInt());
				
			}
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
	

	private void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public int getEventReservation() {
		return eventReservation;
	}
	
	
	//Methods used to reserve a seats at the event
	
	public void reserveSeat() {
		
		if(eventDate.before(currentDate)) {
			
			System.out.println("The event is already passed");
			
		}else if(eventReservation == seatsNumber){
			
			System.out.println("The event is soldout");
			
		}else {
			
			this.eventReservation++;
			
		}
	}
	
	public void reserveSeat( int resNumber) {
		
		if(eventDate.before(currentDate)) {
			
			System.out.println("The event is already passed");
			
		}else if(eventReservation == seatsNumber){
			
			System.out.println("The event is soldout");
			
		}else {
			
			this.eventReservation += resNumber;
			
		}
	}
	
	//Methods used to delete a reservation
	
	public void cancelReservation() {
		
		if(eventDate.before(currentDate)) {
			
			System.out.println("The event is already passed");
			
		}else if(eventReservation == 0){
			
			System.out.println("There are no reservetion to cancel for this event");
			
		}else {
			
			this.eventReservation--;
			
		}
		
	}
	
	
	public void cancelReservation( int cancNumber) {
		
		if(eventDate.before(currentDate)) {
			
			System.out.println("The event is already passed");
			
		}else if(eventReservation == 0){
			
			System.out.println("There are no reservetion to cancel for this event");
			
		}else {
			
			this.eventReservation -= cancNumber;
			
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
	
	//Method used to display info about the number of seats reserved and available
	
	public void seatsInfo() {
	
		System.out.println("Number of reserved seats: " + getEventReservation());
		System.out.println("Number of available seats: " + availableSeats());
		
	}
	
	
	

}
