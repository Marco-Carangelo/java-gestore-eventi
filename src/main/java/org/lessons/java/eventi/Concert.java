package org.lessons.java.eventi;

import java.time.LocalTime;
import java.util.Calendar;

public class Concert extends Event {
	
	private LocalTime concertHour;
	private float concertPrice;

	public Concert(String title, Calendar eventDate, int seatsNumber) {
		super(title, eventDate, seatsNumber);
		
	}

}
