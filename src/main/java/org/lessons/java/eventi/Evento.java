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
	
	//Metodi Getter e Setter


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public Calendar getDataEvento() {
		return dataEvento;
	}


	public void setDataEvento(Calendar dataEvento) {
		this.dataEvento = dataEvento;
	}


	public int getNumPosti() {
		return numPosti;
	}


	public int getNumPrenotazioni() {
		return numPrenotazioni;
	}
	
	
	//Metodo per prenotare un posto all'evento
	
	public void prenotaPosto() {
		
		if(dataEvento.before(dataOdierna)) {
			
			System.out.println("L'evento è già passato");
			
		}else if(numPrenotazioni == numPosti){
			
			System.out.println("I posti per quest'evento sono esauriti");
			
		}else {
			
			numPrenotazioni++;
			
		}
	}
	

}
