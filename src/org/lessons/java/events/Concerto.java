package org.lessons.java.events;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime hour;
	private BigDecimal price;

	public Concerto(String _title, LocalDate _date, int _totalSeats, LocalTime _hour, BigDecimal _price) {
		super(_title, _date, _totalSeats);

		this.hour = _hour;
		this.price = _price;

	}

	public LocalTime getHour() {
		return this.hour;
	}

	public void setHour(LocalTime _hour) {

		LocalTime now = LocalTime.now();

		if (_hour.isBefore(now))
			throw new IllegalArgumentException("Impossibile programmare un concerto indietro nel tempo!");
		else
			this.hour = _hour;

	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal _price) {

		if (_price.compareTo(BigDecimal.ZERO) > 0)
			this.price = _price;
		else
			throw new IllegalArgumentException("Il prezzo dev'essere maggiore di 0!");

	}

	// Utils
	public String getFormattedPrice() {

		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);

		return df.format(this.price) + "€";

	}

	public String formattedDateHour() {

		DateTimeFormatter hourFormatter = DateTimeFormatter.ISO_TIME;

		String dateFormatted = getDate().format(italianDateFormat());
		String hourFormatted = getHour().format(hourFormatter);

		return dateFormatted + " " + hourFormatted;

	}

	@Override
	public String toString() {
		return formattedDateHour() + " - " + getTitle() + " - " + getFormattedPrice();
	}

}
