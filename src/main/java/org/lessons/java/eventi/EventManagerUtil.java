package org.lessons.java.eventi;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;

//Utility class for event manager 

public class EventManagerUtil {
	
	 static Scanner scanner = new Scanner(System.in);
	
	
	//Method that returns a formatted date given a calendar object
	
	public static String dateFormatter(Calendar date){
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd / MM / yyyy");
		
		return (dateFormatter.format(date.getTime()));
		
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
	
	//Method to format a price in the ##,##€ format
		
		public static String priceFormatter( float price) {
			
			String formattedPrice =  String.format("%.2f €", price);
			
			return formattedPrice;
			
		}
		
	
	//Method that takes two variables for hours and minutes and return a localTime object
		
		public static LocalTime setHour(int hour, int minutes) {
			
			LocalTime settedHour = LocalTime.of(hour, minutes);
			
			return settedHour;
			
		}
	
}
