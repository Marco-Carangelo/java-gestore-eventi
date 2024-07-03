package org.lessons.java.eventi;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Inizializziamo un'istanza della classe Scanner per poter acquisire input dall'utente
		
		Scanner scanner = new Scanner(System.in);
		
		//Dichiariazione delle variabili
		
		String titoloNuovoEvento;
		Calendar dataNuovoEvento = null;
		Calendar dataOdierna = Calendar.getInstance();
		int postiNuovoEvento;
		int numeroPrenotazioni;
		
		//Variabili per settare la data di dataNuovoEvento
		
		int annoNuovoEvento;
		int meseNuovoEvento;
		int giornoNuovoEvento;
		
		//Variabile per controllare i cicli d'inserimento dei dati
		
		//boolean check = true;
		
		//Richiediamo all'utente di inserire i dati necessari
		
		System.out.println("Inserisci il titolo dell'evento che si vuole creare: ");
		
		titoloNuovoEvento = scanner.nextLine();
		
		//Acquisizione della data
		
			
		System.out.println("Inserisci la data dell'evento nell'ordine giorno - mese - anno in formato numerico.");
		System.out.println("Per esempio per indicare l'1 gennaio 2025 inserire 1 - 1 - 2025.");
		
		System.out.println("Inserire il giorno dell'evento: ");
		giornoNuovoEvento = scanner.nextInt();
		
		System.out.println("Inserire il mese dell'evento: ");
		meseNuovoEvento = scanner.nextInt();
		
		System.out.println("Inserire l'anno dell'evento: ");
		annoNuovoEvento = scanner.nextInt();
		
		dataNuovoEvento.set(annoNuovoEvento, meseNuovoEvento, giornoNuovoEvento);
	
		
		//Acquisizione del numero di posti totali per l'evento
		
			
		System.out.println("Inserire il numero di posti totali disponibili per l'evento: ");
		postiNuovoEvento = scanner.nextInt();
			
		
		//Creiamo un'istanza della classe Evento e passiamo gli attributi necessari
		
		Evento nuovoEvento = new Evento(titoloNuovoEvento, dataNuovoEvento, postiNuovoEvento);
		
		
		
		
		
		
		

	}

}
