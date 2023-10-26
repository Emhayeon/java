package ex01;

public class PointMain {

	public static void main(String[] args) {
		Point point = new Point();
		point.set(3, 4);
		point.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.set(30, 40);
		cp.showPoint();
		
		ColorPoint cp2 = new ColorPoint();
		cp2.set(300, 400);
		cp2.setColor("RED");
		cp2.showColorPoint();
		

	}

}