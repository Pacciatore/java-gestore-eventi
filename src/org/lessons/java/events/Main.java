package org.lessons.java.events;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// preBonus();

		ProgrammEventi eventsList = new ProgrammEventi("Concerti");

		Evento event = new Evento("Lollo", LocalDate.parse("2023-05-28"), 10);
		eventsList.addEvent(event);
		Evento event1 = new Evento("Pallo", LocalDate.parse("2023-03-28"), 20);
		eventsList.addEvent(event1);
		Evento event2 = new Evento("Lallo", LocalDate.parse("2023-02-28"), 15);
		eventsList.addEvent(event2);
		Evento event3 = new Evento("Frollo", LocalDate.parse("2023-03-28"), 55);
		eventsList.addEvent(event3);

		System.out.println("Sono presenti " + eventsList.getEventsNumber() + " eventi in programma.");

		LocalDate dateFilter = LocalDate.parse("2023-03-28");
		List<Evento> filteredEvents = eventsList.getEventsByDate(dateFilter);

		System.out.println("\nIn data " + dateFilter + " sono presenti i seguenti eventi:");

		for (Evento filteredEvent : filteredEvents) {
			System.out.println(filteredEvent.toString());
		}

		System.out.println();

		System.out.println(eventsList.eventsList());

	}

	public static void preBonus() {

		Scanner s = new Scanner(System.in);

		Evento newEvent = createEvent(s);

		String choice = "";

		System.out.println("Vuoi effettuare prenotazioni? (S/N)");
		choice = s.nextLine();

		// Richiesta di prenotazioni if (choice.toLowerCase().equals("s"))
		bookingRequest(s, newEvent);
		choice = "";
		System.out.println();

		showInfo(newEvent);

		System.out.println("Vuoi disdire delle prenotazioni? (S/N)");
		choice = s.nextLine();

		// Richiesta di cancellazioni if (choice.toLowerCase().equals("s"))
		cancellingRequest(s, newEvent);
		System.out.println();

		showInfo(newEvent);

		System.out.println();
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

	public static void cancellingRequest(Scanner s, Evento show) {

		String choice = "";

		do {

			cancelTicket(s, show);

			choice = "n";

			// Controllo che ci siano ancora posti disponibili
			if (show.getBookedSeats() > 0) {
				System.out.println("Disdire altri biglietti? (S/N)");
				choice = s.nextLine();
			}

		} while (choice.toLowerCase().equals("s"));
	}

	public static void cancelTicket(Scanner s, Evento show) {

		System.out.println(
				"\n-------------------------------------- Cancellazione prenotazione --------------------------------------");

		System.out.println("\nQuante prenotazioni vuoi cancellare?");
		int nTickets = Integer.parseInt(s.nextLine());

		if (nTickets == 1) {
			show.disdici();
			System.out.println("\nHai cancellato " + nTickets + " biglietto.");
		} else if (nTickets > 1) {
			show.disdici(nTickets);
			System.out.println("\nHai cancellato " + nTickets + " biglietti.");
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
