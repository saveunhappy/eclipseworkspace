package webhome;

public class Vehicles {
	String brand;
	String color;
	public void run() {
		System.out.println("我已经开动了");
	}
	public void showinfo() {
		System.out.println("商标为"+brand+"颜色为"+color);
	}
	public Vehicles(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	public Vehicles() {
	}
}
