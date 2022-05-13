package jp.co.axiz.entity;

public class Car {
	private String carName;
	private String bodyColor;
	private int maxSpeed;
	private int speed;
	
	public Car() {
		
	}
	
	public Car(String name, String color, int maxSpeed) {
		this.carName = name;
		this.bodyColor = color;
		this.maxSpeed = maxSpeed;
	}

	public Car(String name, String color, int maxSpeed, int speed) {
		this.carName = name;
		this.bodyColor = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	
	public void setCarName(String name) {
		this.carName = name;
	}
	
	public void setBodyColor(String color) {
		this.bodyColor = color;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed >= 0) {
			this.maxSpeed = maxSpeed;
		} else {
			System.out.println("最高速度に、この値(" + maxSpeed + ")をセットすることはできません");
		}
	}
	
	public void setSpeed(int speed) {
		if (speed > this.getMaxSpeed() || speed < 0) {
			System.out.println("現在速度に、この値(" + speed + ")をセットすることはできません");
		} else {
			this.speed = speed;
		}
	}
	
	public String getCarName() {
		return this.carName;
	}
	
	public String getBodyColor() {
		return this.bodyColor;
	}
	
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
}
