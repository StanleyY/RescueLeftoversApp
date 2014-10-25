package com.example.rescueleftoversapp;

public class PickupDateTuple extends Tuple<Pickup, Date> implements Comparable{
	public PickupDateTuple (Pickup p, Date d) { 
		setFirst(p);
		setSecond(d);
	}

	@Override
	public int compareTo(Object another) {
		if (getSecond().getYear() != (((PickupDateTuple) another).getSecond().getYear())) {
			return (getSecond().getYear()) - (((PickupDateTuple) another).getSecond().getYear());
		} if (getSecond().getMonth() != (((PickupDateTuple) another).getSecond().getMonth())) {
			return (getSecond().getMonth()) - (((PickupDateTuple) another).getSecond().getMonth());
		} if (getSecond().getDay() != (((PickupDateTuple) another).getSecond().getDay())) {
			return (getSecond().getDay()) - (((PickupDateTuple) another).getSecond().getDay());
		}
		return 0;
	}
}
