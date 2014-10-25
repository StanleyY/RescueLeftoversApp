package com.example.rescueleftoversapp;

public class Time implements Comparable<Time> {
	private int hour;
	private int minute;
	private String AMPM;
	
	public Time (int hr, int min, String ampm) {
		AMPM = ampm;
		hour = hr;
		minute = min;
	}
	
	public int getHour() {
		return hour;
	}	
	public void setHour(int h) {
		hour = h;
	}
	
	public int getMinute() {
		return minute;
	}
	public void setMinute(int m) {
		minute = m;
	}
	
	public String getAMPM() {
		return AMPM;
	}
	public void setAMPM(String s) {
		AMPM = s;
	}
	
	public String toString() {
		return hour + ":" + minute + AMPM;
	}
	
	@Override
	public int compareTo(Time t) {
		if (AMPM != t.getAMPM()) {
			if (AMPM == "AM") {
				return 1;
			} else {
				return -1;
			}
		} else if (hour != t.getHour()) {
			return t.getHour() - hour;
		} else if (minute != t.getMinute()) {
			return t.getMinute() - minute;
		}
		return 0;
	}
}
