package org.lessons.java.eventi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//Utility class for event manager 

public class EventManagerUtil {
	
	//Method that returns a formatted date given a calendar object
	
	public static String dateFormatter(Calendar date){
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd / MM / yyyy / kk:mm");
		
		return (dateFormatter.format(date.getTime()));
		
	}
	
	
	//Method used to acquire the fields to populate a calendar object
	
	public static Calendar populateDate() {
		
		Scanner scanner = new Scanner(System.in);
		
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
	
	

}
