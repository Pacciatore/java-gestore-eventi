package org.lessons.java.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

	private LocalTime hour;
	private BigDecimal price;

	public Concerto(String _title, LocalDate _date, int _totalSeats, LocalTime _hour, BigDecimal _price) {
		super(_title, _date, _totalSeats);

		this.hour = _hour;
		this.price = _price;

	}

}
