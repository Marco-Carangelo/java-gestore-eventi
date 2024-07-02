package org.lessons.java.eventi;

import java.util.Calendar;

public class Evento {
	
	//Dichiarazione degli attributi della classe
	
	private String titolo;
	private Calendar dataEvento;
	private int numPosti;
	private int numPrenotazioni = 0;
	private Calendar dataOdierna = Calendar.getInstance();
	
	
	//Costruttore della classe
	
	public Evento(String titolo, Calendar dataEvento , int numPosti) {
		
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.numPosti = numPosti;
		
	}
	
	

}
