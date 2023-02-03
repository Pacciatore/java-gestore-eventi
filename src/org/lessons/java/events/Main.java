package org.lessons.java.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.print("Inserire titolo dell'evento: ");
		String eventTitle = s.nextLine();

		System.out.print("Inserire data dell'evento (yyyy-MM-dd): ");
		String eventDateString = s.nextLine();
		LocalDate eventDate = LocalDate.parse(eventDateString);

		System.out.print("Inserire numero di posti disponibili per l'evento: ");
		int eventTotalSeats = Integer.parseInt(s.nextLine());

		Evento newEvent = new Evento(eventTitle, eventDate, eventTotalSeats);

		s.close();

	}

}
