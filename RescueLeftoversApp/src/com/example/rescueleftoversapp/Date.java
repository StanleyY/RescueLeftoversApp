package com.example.rescueleftoversapp;

public class Date {
	private int month;
	private int year;
	private int day;
	
	
	public Date (int m, int d, int y) {
//		if ((m < 1) || (m > 12)) {
//			throw new Exception();
//		} if (d < 0) {
//			throw new Exception();
//		} if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12)) {
//			if (d > 31) {
//				throw new Exception();
//			}
//		} else if (m == 2) {
//			if ((y % 4) == 0) {
//				if (d > 29) {
//					throw new Exception();
//				}
//			} else if (d > 28) {
//				throw new Exception();
//			}
//		} else {
//			if (d > 30) {
//				throw new Exception ();
//			}
//		}
		month = m;
		day = d;
		year = y;
	}
	
	public int getMonth () {
		return month;
	}
	
	public int getYear () {
		return year;
	}
	
	public int getDay () {
		return day;
	}
}
