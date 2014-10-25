package com.example.rescueleftoversapp;

public abstract class Tuple <T, E>{
	private T first;
	private E second;
	
	public void setFirst (T f) {
		first = f;
	}
	public void setSecond (E s) {
		second = s;
	}
	
	public T getFirst () {
		return first;
	}
	public E getSecond () {
		return second;
	}
}
