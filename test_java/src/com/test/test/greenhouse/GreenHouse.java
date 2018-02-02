package com.test.test.greenhouse;

public class GreenHouse extends Controller{
	// 灯
	private boolean light = false;
	// 水
	private boolean water = false;
	// 温度
	private String thermostat = "Day";
	
	// 开灯
	private class LightOn extends Event {
		public LightOn(long time) {
			super(time);
		}
		@Override
		public void action() {
			light = true;
		}
		@Override
		public String description() {
			return "Light is on!";
		}
	}
	
	private class LightOff extends Event {
		public LightOff(long time) {
			super(time);
		}
		@Override
		public void action() {
			light = false;
		}
		@Override
		public String description() {
			return "Light is off!";
		}
	}
	
	private class WaterOn extends Event {
		public WaterOn(long time) {
			super(time);
		}
		@Override
		public void action() {
			water = true;
		}
		@Override
		public String description() {
			return "Water is on!";
		}
	}
	
	private class WaterOff extends Event {
		public WaterOff(long time) {
			super(time);
		}
		@Override
		public void action() {
			water = false;
		}
		@Override
		public String description() {
			return "Water is off!";
		}
	}
	
	private class ThermostatNight extends Event {
		public ThermostatNight(long time) {
			super(time);
		}
		@Override
		public void action() {
			thermostat = "Night";
		}
		@Override
		public String description() {
			return "Thermostat on Day setting!";
		}
	}
	
	private class ThermostatDay extends Event {
		public ThermostatDay(long time) {
			super(time);
		}
		@Override
		public void action() {
			thermostat = "Day";
		}
		@Override
		public String description() {
			return "Thermostat on Night setting!!";
		}
	}
	
	// 响铃
	private int rings;
	private class Bell extends Event {

		public Bell(long time) {
			super(time);
		}
		@Override
		public void action() {
			if(--rings > 0){
				addEvent(new Bell(System.currentTimeMillis() + 2000));
			}
		}
		@Override
		public String description() {
			return "Ring bell!";
		}
	}
	
	private class Restart extends Event {
		public Restart(long time) {
			super(time);
		}
		@Override
		public void action() {
			long tm = System.currentTimeMillis();
			rings = 5;
			addEvent(new ThermostatNight(tm));
			addEvent(new LightOn(tm + 1000));
			addEvent(new LightOff(tm + 2000));
			addEvent(new WaterOn(tm + 3000));
			addEvent(new WaterOff(tm + 8000));
			addEvent(new Bell(tm + 9000));
			addEvent(new ThermostatDay(tm + 10000));
			//addEvent(new Restart(tm + 20000));
		}
		@Override
		public String description() {
			return "Restarting system";
		}
	}
	
	public static void main(String[] args) {
		GreenHouse greenHouse = new GreenHouse();
		long time = System.currentTimeMillis();
		greenHouse.addEvent(greenHouse.new Restart(time));
		greenHouse.run();
	}
}
