package ex04;

public class Car {
	
	private IBattery battery;

	public Car(IBattery battery1) {
		this.battery = battery1;
	}

	public IBattery getBattery() {
		return battery;
	}
	
	
}
