package org.lessons.java.eventi;

import java.time.LocalTime;
import java.util.Calendar;

public class Concert extends Event {
	
	private LocalTime concertHour;
	private float concertPrice;

	public Concert(String title, Calendar eventDate, int seatsNumber, LocalTime concertHour, float concertPrice) {
		super(title, eventDate, seatsNumber);
		
		this.concertHour = concertHour;
		
		if(concertPrice >= 0) {
			
			this.concertPrice = concertPrice;
			
			if(concertPrice == 0) {
				
				System.out.println("PAY ATTENTION. The event has been setted as free entry");
				
			}
			
		} else {
			
			System.out.println("The price can't be negative.");
			this.concertPrice = concertPrice;
		}
		
		
	}

	public LocalTime getConcertHour() {
		return concertHour;
	}

	public void setConcertHour(LocalTime concertHour) {
		this.concertHour = concertHour;
	}

	public float getConcertPrice() {
		return concertPrice;
	}

	public void setConcertPrice(float concertPrice) {
		this.concertPrice = concertPrice;
	}

	//Override of the toString() method to get event event information formatted into a string

	@Override
	public String toString() {
		
		
		String formattedDate = EventManagerUtil.dateFormatter(getEventDate());
		String formattedPrice = EventManagerUtil.priceFormatter(concertPrice);
		
		return (formattedDate + " " + getConcertHour() + " - " + getEventTitle() + " - " + formattedPrice );
		
		
	}

	
	
	
}

