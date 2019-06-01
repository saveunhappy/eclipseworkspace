package webhome;

public class Car extends Vehicles{
	int seats;
	
	public void showCar() {
		System.out.println("品牌："+brand+"颜色："+color+"能坐"+seats+"人");
	}

	public Car() {
		
	
	}

	public Car(String brand, String color, int seats) {
		super(brand, color);
		this.seats = seats;
	}

	
	
}
