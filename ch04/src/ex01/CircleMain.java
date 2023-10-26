package ex01;

public class CircleMain {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		// Heap 메모리에 생성되는 데이터는 자동 초기화
		System.out.println(c1.radius); //0
		System.out.println(c1.name); //null
		double d =c1.getArea();
		System.out.println(d); //0.0
		
		System.out.println("-----------------------------");
		
		c1.radius = 10;
		c1.name = "도미노피자";
		System.out.println(c1.radius);
		System.out.println(c1.name);
		System.out.println(c1.getArea());

		System.out.println("-----------------------------");
		
		Circle c2 = new Circle();
		c2.radius = 20;
		c2.name = "피자헛";
		System.out.println(c2.radius);
		System.out.println(c2.name);
		System.out.println(c2.getArea());
		
		System.out.println("-----------------------------");
		
		Circle c3 = new Circle(30, "7번가피자");
		System.out.println(c3.getArea());
	}

}
