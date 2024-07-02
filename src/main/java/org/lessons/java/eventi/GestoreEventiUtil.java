package org.lessons.java.eventi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//Classe di utilità del progetto Gestore Eventi

public class GestoreEventiUtil {
	
	//Metodo che prende in ingresso un oggetto di tipo calendar e restituisce una stringa formattata della data a cui si riferisce
	
	public static String formattaData(Calendar data){
		
		SimpleDateFormat formattatoreData = new SimpleDateFormat("dd / MM / yyyy / kk:mm");
		
		return (formattatoreData.format(data.getTime()));
		
	}

}
