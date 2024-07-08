package org.lessons.java.eventi;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Scanner class instance to acquire input by user
		
		Scanner scanner = new Scanner(System.in);
		
		//Main method variables definition
		
		String newEventTitle;
		Calendar newEventDate = Calendar.getInstance();
		int newEventSeats;
		int numberOfReservations;
		int numnerOfCancellations;
		
		//The data insertion is in a while loop, to consent to repeat it if some values is wrong
		
		boolean check = true;
		while(check) {	
		
			//Ask to user the title of the new event
			
			System.out.println("Enter the title of the new event: ");
			
			newEventTitle = scanner.nextLine();
			
			//Ask to user the date of the new event
				
			System.out.println("\nEnter the date of the new event in the order year, month, day in numeric form");
			System.out.println("For example, to indicate April 1 2025 enter 2025 - 4 - 1");
			
			System.out.println("\nEnter the year of the event: ");
			int newEventYear = scanner.nextInt();
			
			System.out.println("\nEnter the month of the event: ");
			int newEventMonth = (scanner.nextInt() - 1);
			
			System.out.println("\nEnter the day of the event: ");
			int newEventDay = scanner.nextInt();
			
			newEventDate.set(newEventYear, newEventMonth, newEventDay);
			
			//Ask to user the number of seats of the new event
				
			System.out.println("\nEnter the number of seats expected for the event: ");
			newEventSeats = scanner.nextInt();
			scanner.nextLine();
				
			
			//Instance of the Event class
			
			Event newEvent = new Event(newEventTitle, newEventDate, newEventSeats);
			
			//The part of the code regarding reservation and print event info is executed
			//only if the data entered is correct
			
			if(newEvent.getEventDate() != null && newEvent.getSeatsNumber() > 0 ) {
		
				//Print event information to check the correct creation of the instance
				System.out.println("\nShort description of the event: " + newEvent.toString());
				
				//Ask user if he wants to make any reservation and if yes, how many of it
				//The program exit the loop when the reservation are validated and finalized or when he choose to not enter a reservation
				
				check = true;
				while(check) {
					
					System.out.println("\nDo you want to make one or more reservation?");
					
					if(EventManagerUtil.choiceManager()) {
						
						//Ask user how many reservation wants to make
				
						System.out.println("\nHow many seats do you want to reserve?");
						numberOfReservations = scanner.nextInt();
						scanner.nextLine();
						
						//Check if the number entered is greater then the available seats and if so warns the user
						if(numberOfReservations <= newEvent.availableSeats()) {
							
							newEvent.reserveSeat(numberOfReservations);	
							check = false;
							
						}else {
							
							System.out.println("Sorry but number of available seats are only " + newEvent.availableSeats() + "\nA reservetion for an higher number cannot be booked" );
							
						}
						
						
					}else {
						
						check = false;
					}
					
					
				}//End of the loop for reservation
				
				
				//Print information about available and reserved seats
				
				newEvent.seatsInfo();
				
				//Ask user if he wants to cancel a reservation
				//Reset of the check variable
				check = true;
				while(check) {
					
					System.out.println("\nDo you want to cancel one or more reservation?");
					
					if(EventManagerUtil.choiceManager()) {
						
						//Ask user how many reservation wants to cancel
						
						System.out.println("\nHow many reservation do you want to cancel?");
						numnerOfCancellations = scanner.nextInt();
						scanner.nextLine();
						
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
					
				}//End of the loop to manage cancellation
				
				
				//Print information about available and reserved seats
			
				newEvent.seatsInfo();
				
				check = false;
				
		}
			
			//Else of the first loop, in which we create the instance of the Event class
			else {
			
			System.out.println("The event data insertion must be repeated");
			
		}
		
	}
		
		
		
		//SECTION TO TEST THE CONCERT SUBCLASS
		
		
		
		System.out.println("*********************************************");
		
		//Declaration of the additional variables to populate the concert instance
		
		int concertHour;
		int concertMinutes;
		LocalTime concertTime = null;
		float concertPrice;
		
		check = true;
		while(check) {	
		
			//Ask to user the title of the new event
			
			System.out.println("\nEnter the title of the new event: ");
			
			newEventTitle = scanner.nextLine();
			
			//Ask to user the date of the new event
				
			System.out.println("\nEnter the date of the new event in the order year, month, day in numeric form");
			System.out.println("For example, to indicate April 1 2025 enter 2025 - 4 - 1");
			
			
			System.out.println("\nEnter the year of the event: ");
			int newEventYear = scanner.nextInt();
			
			System.out.println("\nEnter the month of the event: ");
			int newEventMonth = (scanner.nextInt() - 1);
			
			System.out.println("\nEnter the day of the event: ");
			int newEventDay = scanner.nextInt();
			
			newEventDate.set(newEventYear, newEventMonth, newEventDay);
			
			//Ask to user the hour of the event
			
			System.out.println("\nEnter the hour of the event in the order hours and then minutes");
			
			System.out.println("\nEnter the hour: ");
			concertHour = scanner.nextInt();
			
			System.out.println("\nEnter the minutes: ");
			concertMinutes = scanner.nextInt();
			
			concertTime = LocalTime.of(concertHour, concertMinutes);
			
			//Ask to user the number of seats of the new event
				
			System.out.println("\nEnter the number of seats expected for the event: ");
			newEventSeats = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("\nEnter the concert price: ");
			concertPrice = scanner.nextFloat();
			scanner.nextLine();
			
			Event newConcert = new Concert(newEventTitle, newEventDate, newEventSeats, concertTime, concertPrice);
			
			
			//The part of the code regarding print event info is executed only if the data entered is correct
			
			if(newConcert.getEventDate() != null && newConcert.getSeatsNumber() > 0 ) {
				
				//Print the information about the concert
				
				System.out.println(newConcert.toString());
				newConcert.seatsInfo();;
				
				check = false;
				
		}else {
			
			System.out.println("The event data insertion must be repeated");
			
		}
		
	}
		
		//SECTION TO TEST THE EventProgram CLASS
		
		System.out.println("\n***********************************************\n");
		
		//Ask to user the title of the program
		System.out.println("\nEnter the title of the new event program: ");
		String newProgramTitle = scanner.nextLine();
		
		//Create an instance of the EventProgram class
		EventProgram newProgram = new EventProgram(newProgramTitle );
		
		//Test the addEvent method by creating three events and adding them to newProgram
		
		//Set a new date before passing it to the constructor. We set two equal dates for later test
		newEventDate.set(2024, 11, 1);
		Event testEvent1 = new Event("Conferenza java", newEventDate, 400 );
		
		Event testEvent2 = new Event("Presentazione libro M.P.", newEventDate, 100 );
		
		newEventDate.set(2025, 4, 1);
		Event testEvent3 = new Event("Mostra sugli Allosauri", newEventDate, 500 );
		
		//Test the addEvent method
		newProgram.addEvent(testEvent2);
		newProgram.addEvent(testEvent3);
		newProgram.addEvent(testEvent1);
		
		//Test the method to print the number of element in the list
		System.out.println("\nThe number of events in this program is: " + newProgram.eventListSize());
		
		//Test the method to get a list of events at a specific date
		
		Calendar dateToCheck = Calendar.getInstance();
		dateToCheck.set(2024, 11, 1);
		
		List<Event> listAtDate = new ArrayList<Event>();
		
		listAtDate.addAll(newProgram.checkEventsAtDate(dateToCheck));
		
		System.out.println("\nList of events on the date " + EventManagerUtil.dateFormatter(dateToCheck) + ":\nboh" );
		
		for(Event ev: listAtDate) {
			System.out.println(ev.toString());
		}
		
		//Test the method to get the program Title and the list of event sorted by date
		
		newProgram.eventListByDate();
		
		//Test the method to clear the list and then try check if the list is empty
		
		newProgram.clearEventList();
		
		if(newProgram.getEventList().isEmpty())
			System.out.println("\nList emptiness verified");
		
		scanner.close();
	}
	
	

}
