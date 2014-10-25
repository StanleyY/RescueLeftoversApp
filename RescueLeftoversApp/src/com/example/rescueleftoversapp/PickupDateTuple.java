package com.example.rescueleftoversapp;

public class PickupDateTuple extends Tuple<Pickup, Date> implements Comparable<PickupDateTuple>{
	public PickupDateTuple (Pickup p, Date d) { 
		setFirst(p);
		setSecond(d);
	}

	@Override
	public int compareTo(PickupDateTuple another) {
		if (getSecond().getYear() != (another.getSecond().getYear())) {
			return (getSecond().getYear()) - (another.getSecond().getYear());
		} if (getSecond().getMonth() != (another.getSecond().getMonth())) {
			return (getSecond().getMonth()) - (another.getSecond().getMonth());
		} if (getSecond().getDay() != (another.getSecond().getDay())) {
			return (getSecond().getDay()) - (another.getSecond().getDay());
		}
		return 0;
	}
}
