package webhome;

public class Truck extends Vehicles{
	float load;
	public void showTruck() {
		System.out.println("品牌："+brand+"颜色："+color+"载重"+load+"斤");
		
	}
	public Truck(String brand, String color, float load) {
		super(brand, color);
		this.load = load;
	}
	public Truck() {
		
	}
	
	
}
