package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

	private String date;
	private String time;
	
	public DateAndTime() {
	
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

		this.date = currentDate.format(dateFormat);
		this.time = currentTime.format(timeFormat);
	}
	
	public String getDate() {
		
		return this.date;
	}
	
	public String getTime() {
		
		return this.time;
	}
	
	public String getDateAndTime() {
		
		return this.date + " " + this.time;
	}
}
