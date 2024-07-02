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
		
		//Variabili per settare la data di dataNuovoEvento
		
		int annoNuovoEvento;
		int meseNuovoEvento;
		int giornoNuovoEvento;
		
		//Variabile per controllare i cicli d'inserimento dei dati
		
		boolean check = true;
		
		//Richiediamo all'utente di inserire i dati necessari
		
		System.out.println("Inserisci il titolo dell'evento che si vuole creare: ");
		
		titoloNuovoEvento = scanner.nextLine();
		
		//Ciclo per acquisire i campi della data e validarne l'input
		
		do {
			
			System.out.println("Inserisci la data dell'evento nell'ordine giorno - mese - anno in formato numerico.");
			System.out.println("Per esempio per indicare l'1 gennaio 2025 inserire 1 - 1 - 2025.");
			
			System.out.println("Inserire il giorno dell'evento: ");
			giornoNuovoEvento = scanner.nextInt();
			
			System.out.println("Inserire il mese dell'evento: ");
			meseNuovoEvento = scanner.nextInt();
			
			System.out.println("Inserire l'anno dell'evento: ");
			annoNuovoEvento = scanner.nextInt();
			
			dataNuovoEvento.set(annoNuovoEvento, meseNuovoEvento, giornoNuovoEvento);
			
			if(dataNuovoEvento.after(dataOdierna)) {
				
				check = true;
				
			}
				
			else {
				
				System.out.println("La data inserita è già passata. Si prega di inserire una data valida.");
				check = false;
			}
				
			
		}while(!check);
		
		
		//Ciclo per acquisire il numero di posti totali e validare l'inpuit
		
		do {
			
			System.out.println("Inserire il numero di posti totali disponibili per l'evento: ");
			postiNuovoEvento = scanner.nextInt();
			
			if(postiNuovoEvento > 0) {
				
				check = true;
				
			}
				
			else {
				
				System.out.println("Il numero di posti dev'essere maggiore di 0, inserire un valore valido.");
				check = false;
			}
			
		}while(!check);
		
		

	}

}
