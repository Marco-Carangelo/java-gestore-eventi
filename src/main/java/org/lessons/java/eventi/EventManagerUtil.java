package org.lessons.java.eventi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//Utility class for event manager 

public class EventManagerUtil {
	
	//Method that returns a formatted date given a calendar object
	
	public static String dateFormatter(Calendar date){
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd / MM / yyyy / kk:mm");
		
		return (dateFormatter.format(date.getTime()));
		
	}
	
	
	//Metodo per acquisire i campi di un oggetto di tipo data
	
	

}
