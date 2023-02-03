package org.lessons.java.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		Evento newEvent = createEvent(s);

		String choice = "";

		System.out.println("Vuoi effettuare prenotazioni? (S/N)");
		choice = s.nextLine();

		if (choice.toLowerCase().equals("s"))
			bookingRequest(s, newEvent);

		showInfo(newEvent);

		System.out.println("Chiusura del programma...");

		s.close();

	}

	public static Evento createEvent(Scanner s) {

		System.out.print("Inserire titolo dell'evento: ");
		String eventTitle = s.nextLine();

		System.out.print("Inserire data dell'evento (yyyy-MM-dd): ");
		String eventDateString = s.nextLine();
		LocalDate eventDate = LocalDate.parse(eventDateString);

		System.out.print("Inserire numero di posti disponibili per l'evento: ");
		int eventTotalSeats = Integer.parseInt(s.nextLine());

		return new Evento(eventTitle, eventDate, eventTotalSeats);

	}

	public static void bookingRequest(Scanner s, Evento show) {

		String choice = "";

		do {

			bookTicket(s, show);

			choice = "n";

			// Controllo che ci siano ancora posti disponibili
			if (show.getBookedSeats() < show.getTotalSeats()) {
				System.out.println("Prenotare altri biglietti? (S/N)");
				choice = s.nextLine();
			}

		} while (choice.toLowerCase().equals("s"));
	}

	public static void bookTicket(Scanner s, Evento show) {

		System.out.println(
				"\n-------------------------------------- Prenotazione evento --------------------------------------");

		System.out.println("\nQuante prenotazioni vuoi effettuare?");
		int nTickets = Integer.parseInt(s.nextLine());

		if (nTickets == 1) {
			show.prenota();
			System.out.println("\nHai prenotato " + nTickets + " biglietto.");
		} else if (nTickets > 1) {
			show.prenota(nTickets);
			System.out.println("\nHai prenotato " + nTickets + " biglietti.");
		}

		System.out.println("Biglietti rimanenti: " + (show.getTotalSeats() - show.getBookedSeats()));

	}

	public static void showInfo(Evento show) {

		System.out.println("--------------------------------------");

		System.out.println(show.toString());

		System.out.println("Posti totali: " + show.getTotalSeats());

		System.out.println("Posti prenotati: " + show.getBookedSeats());

		System.out.println("Posti disponibili: " + (show.getTotalSeats() - show.getBookedSeats()));

		System.out.println("--------------------------------------");

	}

}
