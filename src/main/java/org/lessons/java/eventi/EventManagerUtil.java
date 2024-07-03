package org.lessons.java.eventi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//Utility class for event manager 

public class EventManagerUtil {
	
	 static Scanner scanner = new Scanner(System.in);
	
	
	//Method that returns a formatted date given a calendar object
	
	public static String dateFormatter(Calendar date){
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd / MM / yyyy / kk:mm");
		
		return (dateFormatter.format(date.getTime()));
		
	}
	
	
	//Method used to acquire the fields to populate a calendar object
	
	public static Calendar populateDate() {
		
		
		
		System.out.println("Enter the year of the event: ");
		int newEventYear = scanner.nextInt();
		
		System.out.println("Enter the month of the event: ");
		int newEventMonth = (scanner.nextInt() - 1);
		
		System.out.println("Enter the day of the event: ");
		int newEventDay = scanner.nextInt();
		
		Calendar newEventDate = Calendar.getInstance();
		
		newEventDate.set(newEventYear, newEventMonth, newEventDay);
		
		return newEventDate;
		
	}
	
	
	//Method to manage a choice between yes or not
	
		static public boolean choiceManager() {
			
			boolean choice = false;
			String userInput;
			char userChoice = 0;
			
			//If the value inserted is not coherent the user is warned and invited to choice again
			
			do{
				
				System.out.println("Enter Y for Yes or N for No");
				
				userInput = scanner.next().toLowerCase();	
				userChoice = userInput.charAt(0);
				
				if(userChoice != 'y' && userChoice != 'n' && userInput.length() != 1)
					System.out.println("Insert a valid value");
				
				
				} while((userChoice != 'y' && userChoice != 'n') || userInput.length() != 1);

			
			if(userChoice == 'y') {
				
				choice = true;
				
			}else {
				
				choice = false;
				
				}
			
			return choice;
		}
	
	
	
}
