package org.lessons.java.events;

import java.time.LocalDate;

public class Evento {

	private String title;
	private LocalDate date;
	private int totalSeats;
	private int bookedSeats;

	public Evento(String _title, LocalDate _date, int _totalSeats) {
		this.title = _title;
		this.date = _date;
		this.totalSeats = _totalSeats;
		this.bookedSeats = 0;
	}

	public String getTitle() {
		return this.title;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public int getTotalSeats() {
		return this.totalSeats;
	}

	public int getBookedSeats() {
		return this.bookedSeats;
	}

}
