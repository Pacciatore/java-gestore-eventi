package org.lessons.java.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {

	private String title;
	private List<Evento> events;

	public ProgrammEventi(String _title) {
		this.title = _title;
		this.events = new ArrayList<Evento>();
	}

	public void addEvent(Evento event) {
		this.events.add(event);
	}

	public int getEventsNumber() {
		return this.events.size();
	}

	public void clearEvents() {
		this.events.clear();
	}

	public List<Evento> getEventsByDate(LocalDate date) {

		List<Evento> eventsByDate = new ArrayList<Evento>();

		for (Evento event : this.events) {
			if (event.getDate().equals(date))
				eventsByDate.add(event);
		}

		return eventsByDate;
	}

	public String eventsList() {

		// Dichiaro un nuovo comparatore su cui basare il riordino (sort)
		Collections.sort(this.events, new Comparator<Evento>() {
			// Il risultato della comparazione viene restituito come un intero
			public int compare(Evento e1, Evento e2) {
				return e1.getDate().compareTo(e2.getDate());
			}
		});

		StringBuilder eventsListBuilder = new StringBuilder();

		for (Evento event : this.events) {
			eventsListBuilder.append(event.toString() + "\n");
		}

		return this.title + "\n" + eventsListBuilder;

	}

}
