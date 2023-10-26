package ex04;

public class CarMain {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.drive();
		
		SuperCar sc1 = new SuperCar();
		sc1.drive();
		
		Car c2 = new SuperCar();//업캐스팅
		c2.drive();
	}

}
