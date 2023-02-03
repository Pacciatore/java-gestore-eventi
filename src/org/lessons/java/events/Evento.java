package org.lessons.java.events;

import java.time.LocalDate;

public class Evento {

	private String title;
	private LocalDate date;
	private int totalSeats;
	private int bookedSeats;

	public Evento(String _title, LocalDate _date, int _totalSeats) {

		this.title = _title;
		setDate(_date);

		if (_totalSeats > 0)
			this.totalSeats = _totalSeats;
		else
			throw new IllegalArgumentException("I posti totali devono essere maggiori di 0!");

		this.bookedSeats = 0;

	}

	// Getters e Setters
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String _title) {

		if (_title.trim().length() > 0 && !_title.trim().equals(""))
			this.title = _title;
		else
			throw new IllegalArgumentException("Il titolo non può essere vuoto!");

	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate _date) {

		LocalDate now = LocalDate.now();

		if (_date.isBefore(now))
			throw new IllegalArgumentException("La data dell'evento non può essere precedente alla data di oggi!");
		else
			this.date = _date;

	}

	public int getTotalSeats() {
		return this.totalSeats;
	}

	public int getBookedSeats() {
		return this.bookedSeats;
	}

	// Funzioni
	public void prenota() {
		LocalDate now = LocalDate.now();

		if (now.isBefore(getDate()) && bookedSeats < totalSeats)
			bookedSeats++;
		else if (now.isAfter(getDate()))
			throw new IllegalArgumentException("L'evento è già passato!");
		else if (bookedSeats >= totalSeats)
			throw new IllegalArgumentException("I posti per l'evento sono terminati!");

	}

}
