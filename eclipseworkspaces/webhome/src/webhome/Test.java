package webhome;

public class Test {
	public static void main(String[] args) {
		Vehicles vehicles = new Vehicles("奔驰","黑色");
		vehicles.run();
		vehicles.showinfo();
		Car car = new Car("宝马","白色",4);
		car.showCar();
		Truck truck = new Truck("路虎","黑色",10000f);
		truck.showinfo();
		
	}
}
