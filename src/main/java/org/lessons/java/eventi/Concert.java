package org.lessons.java.eventi;

import java.time.LocalTime;
import java.util.Calendar;

public class Concert extends Event {
	
	private LocalTime concertHour;
	private float concertPrice;

	public Concert(String title, Calendar eventDate, int seatsNumber, LocalTime concertHour, float concertPrice) {
		super(title, eventDate, seatsNumber);
		
		this.concertHour = concertHour;
		this.concertPrice = concertPrice;
		
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

	
	
	
}

