package com.test.test.greenhouse;

public abstract class Event {
	private long time;
	public Event(long time) {
		this.time = time;
	}
	
	public boolean ready(){
		return System.currentTimeMillis() >= time;
	}
	
	public abstract void action(); 
	public abstract String description(); 
}