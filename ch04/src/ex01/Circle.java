package ex01;

public class Circle {
	//멤버필드(데이터)
	public int radius; //반지름
	public String name; //이름
	
	//생성자
	public Circle(){}
	
	public Circle(int r, String n){
		radius = r;
		name = n;
	}
	
	//멤버 메서드(기능)
	public double getArea() {
		//반지름 *반지름*3.14
		double area = radius*radius* Math.PI;
		return area;
	}


}
