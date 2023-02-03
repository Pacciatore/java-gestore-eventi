package org.lessons.java.events;

import java.time.LocalDate;
import java.util.ArrayList;
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

}
