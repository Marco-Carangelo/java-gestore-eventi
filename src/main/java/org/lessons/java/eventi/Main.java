package org.lessons.java.eventi;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Scanner classe instance to acquire input by user
		
		Scanner scanner = new Scanner(System.in);
		
		//Main method variables definition
		
		String newEventTitle;
		Calendar newEventDate = null;
		Calendar currentDate = Calendar.getInstance();
		int newEventSeats;
		int numberOfReservations;
		
		//Variabili per settare la data di dataNuovoEvento
		
		int newEventYear;
		int newEventMonth;
		int newEventDay;
		
		//Variabile per controllare i cicli d'inserimento dei dati
		
		//boolean check = true;
		
		//Ask to user the title of the new event
		
		System.out.println("Enter the title of the new event: ");
		
		newEventTitle = scanner.nextLine();
		
		//Ask to user the date of the new event
		
			
		System.out.println("Enter the date of the new event in the order year, month, day in numeric form");
		System.out.println("For example, to indicate April 1 2025 enter 2025 - 4 - 1");
		
		System.out.println("Enter the year of the event: ");
		newEventYear = scanner.nextInt();
		
		System.out.println("Enter the month of the event: ");
		newEventMonth = (scanner.nextInt() - 1);
		
		System.out.println("Enter the day of the event: ");
		newEventDay = scanner.nextInt();
		
		newEventDate.set(newEventYear, newEventMonth, newEventDay);
	
		
		//Ask to user the number of seats of the new event
		
			
		System.out.println("Enter the number of seats expected for the event: ");
		newEventSeats = scanner.nextInt();
			
		
		//Instance of the Event class
		
		Event newEvent = new Event(newEventTitle, newEventDate, newEventSeats);
		
		// fare due cicli while(data == null) e while(numPosti == 0)
		
		
		
		
		

	}

}
