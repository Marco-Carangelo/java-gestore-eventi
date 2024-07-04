package org.lessons.java.eventi;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Scanner classe instance to acquire input by user
		
		Scanner scanner = new Scanner(System.in);
		
		//Main method variables definition
		
		String newEventTitle;
		Calendar newEventDate = Calendar.getInstance();
		//Calendar currentDate = Calendar.getInstance();
		int newEventSeats;
		int numberOfReservations;
		int numnerOfCancellations;
		
		//Variable used to check continuation of while cycles
		boolean check = true;
		
		while(check) {	
		
			//Ask to user the title of the new event
			
			System.out.println("Enter the title of the new event: ");
			
			newEventTitle = scanner.nextLine();
			
			//Ask to user the date of the new event
				
			System.out.println("Enter the date of the new event in the order year, month, day in numeric form");
			System.out.println("For example, to indicate April 1 2025 enter 2025 - 4 - 1");
			
			System.out.println("Enter the year of the event: ");
			int newEventYear = scanner.nextInt();
			
			System.out.println("Enter the month of the event: ");
			int newEventMonth = (scanner.nextInt() - 1);
			
			System.out.println("Enter the day of the event: ");
			int newEventDay = scanner.nextInt();
			
			newEventDate =  (Calendar) EventManagerUtil.populateDate(newEventYear,newEventMonth, newEventDay ).clone();
			
			//Ask to user the number of seats of the new event
				
			System.out.println("Enter the number of seats expected for the event: ");
			newEventSeats = scanner.nextInt();
			scanner.nextLine();
				
			
			//Instance of the Event class
			
			Event newEvent = new Event(newEventTitle, newEventDate, newEventSeats);
			
		
			if(newEvent.getEventDate() != null && newEvent.getSeatsNumber() > 0 ) {
		
				//Print event information to check the correct creation of the instance
				System.out.println(newEvent.toString());
				
				
				//Ask user if he wants to make any reservation and if yes, how many of it
				
				check = true;
				
				while(check) {
					
					System.out.println("Do you want to make one or more reservation?");
					
					if(EventManagerUtil.choiceManager()) {
						
						//Ask user how many reservation wants to make
						
						System.out.println("How many seats do you want to reserve?");
						numberOfReservations = scanner.nextInt();
						
						if(numberOfReservations <= newEvent.availableSeats()) {
							
							newEvent.reserveSeat(numberOfReservations);	
							check = false;
							
						}else {
							
							System.out.println("Sorry but number of available seats are only " + newEvent.availableSeats() + "\nA reservetion for an higher number cannot be booked" );
							
						}
						
						
					}
					
					else {
						
						check = false;
					}
					
					
				}
				
				
				//Print information about available and reserved seats
				
				newEvent.seatsInfo();
				
				//Reset of the check variable
				check = true;
				
				
				//Ask user if he wants to cancel a reservation
				
				while(check) {
					
					System.out.println("Do you want to cancel one or more reservation?");
					
					if(EventManagerUtil.choiceManager()) {
						
						//Ask user how many reservation wants to cancel
						
						System.out.println("How many reservation do you want to cancel?");
						numnerOfCancellations = scanner.nextInt();
						
						if(numnerOfCancellations <= newEvent.getEventReservation()) {
							
							newEvent.cancelReservation(numnerOfCancellations);	
							check = false;
							
						}else {
							
							System.out.println("Sorry but number of reserved seats are only " + newEvent.getEventReservation() + "\nA cancellation for an higher number cannot be done" );
							
						}
						
						
					}
					
					else {
						
						check = false;
					}
					
				}
				
				
				//Print information about available and reserved seats
			
				newEvent.seatsInfo();
				
				check = false;
		}else {
			
			System.out.println("The event data insertion must be repeated");
			
		}
		
	}
		
//		//SECTION TO TEST THE CONCERT SUBCLASS
//		
//		System.out.println("*********************************************");
//		
//		//Declaration of the additional variables to populate the concert instance
//		
//		int concertHour;
//		int concertMinutes;
//		LocalTime concertTime;
//		float concertPrice;
//		
//		System.out.println("\nEnter the title of the new event: ");
//		newEventTitle = scanner.next();
//		
//		System.out.println("Enter the date of the new event in the order year, month, day in numeric form");
//		System.out.println("For example, to indicate April 1 2025 enter 2025 - 4 - 1");
//		
//		newEventDate =  (Calendar) EventManagerUtil.populateDate().clone();
//		
//		System.out.println("Enter the hour of the event in the order hours and then minutes");
//		System.out.println("Enter the hour: ");
//		concertHour = scanner.nextInt();
//		System.out.println("Enter the minutes: ");
//		concertMinutes = scanner.nextInt();
//		concertTime = EventManagerUtil.setHour(concertHour, concertMinutes);
//		
//		System.out.println("Enter the number of seats expected for the event: ");
//		newEventSeats = scanner.nextInt();
//		
//		System.out.println("Enter the concert price: ");
//		concertPrice = scanner.nextFloat();
//		
//		Event newConcert = new Concert(newEventTitle, newEventDate, newEventSeats, concertTime, concertPrice);
//		
//		System.out.println(newConcert.toString());
//		newConcert.getSeatsNumber();
//		
		
		
		
		
		
		scanner.close();
	}
	
	

}
