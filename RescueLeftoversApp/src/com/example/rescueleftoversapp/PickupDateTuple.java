package com.example.rescueleftoversapp;

public class PickupDateTuple extends Tuple<Pickup, Date> implements Comparable<PickupDateTuple>{
	public PickupDateTuple (Pickup p, Date d) { 
		setFirst(p);
		setSecond(d);
	}

	@Override
	public int compareTo(PickupDateTuple another) {
		if (getSecond().getYear() != (another.getSecond().getYear())) {
			return another.getSecond().getYear() - getSecond().getYear();
		} if (getSecond().getMonth() != (another.getSecond().getMonth())) {
			return another.getSecond().getMonth() - getSecond().getMonth();
		} if (getSecond().getDay() != (another.getSecond().getDay())) {
			return another.getSecond().getDay() - getSecond().getDay();
		}
		return 0;
	}
}
