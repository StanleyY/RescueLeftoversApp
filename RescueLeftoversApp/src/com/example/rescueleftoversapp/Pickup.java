package com.example.rescueleftoversapp;

import java.util.ArrayList;

public class Pickup {
	private String address;
	private String restaurantName;
	private Date date;
	private Time StartTime;
	private Time EndTime;
	private int totalWeight;
	private int accumulatedWeight;
	private String description;
	private int numVolunteers;
	private ArrayList<UserWeightTuple> attendants;
	private ArrayList<UserWeightTuple> waitlist;
	private boolean visibleToVolunteers; 
	private LeaderUser leader;
	
	public Pickup (String restaurant, Date d, Time start, Time end, String addr, int weight, String desc) {
		address = addr;
		restaurantName = restaurant;
		date = d;
		StartTime = start;
		EndTime = end;
		totalWeight = weight;
		accumulatedWeight = 0;
		description = desc;
		numVolunteers = 0;
		attendants = new ArrayList<UserWeightTuple>();
		waitlist = new ArrayList<UserWeightTuple>();
		visibleToVolunteers = false;
		leader = null;
	}
	
	public Pickup (String restaurant, Date d, Time start, Time end, String addr, int weight) {
		address = addr;
		restaurantName = restaurant;
		date = d;
		StartTime = start;
		EndTime = end;
		totalWeight = weight;
		accumulatedWeight = 0;
		description = "";
		numVolunteers = 0;
		attendants = new ArrayList<UserWeightTuple>();
		waitlist = new ArrayList<UserWeightTuple>();
		visibleToVolunteers = false;
		leader = null;
	}
	
	public String getRestaurantName () {
		return restaurantName;
	}
	public void setRestaurantName (String name) {
		restaurantName = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		address = add;
	}
	
	public Date getDate () {
		return date;
	}
	public void setDate (Date d) {
		date = d;
	}
	
	public Time getStart () {
		return StartTime;
	}
	public void setStart (Time time) {
		StartTime = time;
	}
	
	public Time getEnd () {
		return EndTime;
	}
	public void setEnd (Time time) {
		EndTime = time;
	}
	
	public int getTotal () {
		return totalWeight;
	}
	public void setTotal (int t) {
		totalWeight = t;
	}
	
	public int getAccumulated () {
		return accumulatedWeight;
	}
	public void setAccumulated (int weight) {
		accumulatedWeight = weight;
	}
	
	public String getDescription () {
		return description;
	}
	public void setDescription (String desc) {
		description = desc;
	}
	
	public int getNumVolunteers () {
		return numVolunteers;
	}
	public void setNumVolunteers (int n) {
		numVolunteers = n;
	}
	
	public ArrayList<UserWeightTuple> getAttendants () {
		return attendants;
	}

	public ArrayList<UserWeightTuple> getWaitlist () {
		return waitlist;
	}
	
	public boolean getVisibileToVolunteers () {
		return visibleToVolunteers;
	}
	
	public LeaderUser getLeader () {
		return leader;
	}
	
	// Return true if add successful, return false if user already in the list
	public boolean addUser (User person, int weight) {
		boolean temp = true;
		for (UserWeightTuple i : attendants) {
			if (i.getFirst() == person) {
				temp = false;
			}
		}
		if (temp) {
			attendants.add(new UserWeightTuple(person, Integer.valueOf(weight)));
		}
		return temp;
	}
	
	// Returns true if drop successful, return false if user not in the list.
	public boolean dropUser (User person) {
		boolean temp = false;
		for (UserWeightTuple i : attendants) {
			if (i.getFirst() == person) {
				temp = true;
				attendants.remove(i);
			}
		}
		return temp;
	}
	
	// Returns true of add onto waitlist successful, false if user is already on the list.
	public boolean waitlistAdd (User person, int weight) {
		boolean temp = true;
		for (UserWeightTuple i : waitlist) {
			if (i.getFirst() == person) {
				temp = false;
			}
		}
		if (temp) {
			waitlist.add(new UserWeightTuple(person, Integer.valueOf(weight)));
		}
		return temp;
	}
	
	// Returns true if leader is added. Returns false if leader already exists
	public boolean addLeader (LeaderUser person, int weight) {
		if (leader == null) {
			visibleToVolunteers = true;
			leader = person;
			addUser(person, weight);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean overlaps (Pickup p) {
		Date d = p.getDate();
		if ((date.getMonth() == d.getMonth()) && (date.getDay() == d.getDay()) && (date.getYear() == d.getYear())) {
			Time s = p.getStart();
			Time e = p.getEnd();
			if ((StartTime.compareTo(s) >= 0) && (EndTime.compareTo(s) <= 0)) {
				return true;
			} else if ((StartTime.compareTo(e) >= 0) && (EndTime.compareTo(e) <= 0)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean earlierThan (Pickup p) {
		Date d = p.getDate();
		if (date.getYear() != d.getYear()) {
			return date.getYear() < d.getYear();
		} else if (date.getMonth() != d.getMonth()) {
			return date.getMonth() < d.getMonth();
		} else if (date.getDay() != d.getDay()) {
			return date.getDay() < d.getDay();
		} else {
			return (StartTime.compareTo(p.getStart()) > 0);
		}
	}
	
	public String[] display () {
		String[] x = new String[7];
		x[0] = restaurantName;
		x[1] = address;
		x[2] = "People: " + numVolunteers;
		x[3] = "Weight alotted: " + accumulatedWeight + "/" + totalWeight;
		if (leader == null) {
			x[4] = "No Leader";
		} else {
			x[4] = "Lead Rescuer: " + leader.getName();
		}
		x[5] = "Description: " + description;
		x[6] = "Time: " + StartTime + "-" + EndTime + " on " + date.toString();
		return x;
	}
}
