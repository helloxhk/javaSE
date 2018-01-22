package com.test.enums.trafficlight;

public enum TrafficLamp {
	RED(30) {
		@Override
		public TrafficLamp nextLamp() {
			return GREEN;
		}
	},GREEN(45) {
		@Override
		public TrafficLamp nextLamp() {
			return YELLOW;
		}
	},YELLOW(5) {
		@Override
		public TrafficLamp nextLamp() {
			return RED;
		}
	};
	public abstract TrafficLamp nextLamp();
	private int time;
	TrafficLamp(int time){
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	};
}
