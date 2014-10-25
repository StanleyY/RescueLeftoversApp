package com.example.rescueleftoversapp;

public class Time {
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
	
	public int setMinute() {
		return minute;
	}
	public void getMinute(int m) {
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
}
