package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RectAngleMain {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle();
		
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.print("width:");
		 r1.width = scanner.nextInt();
		 
		 System.out.print("height:");
		 r1.height= scanner.nextInt();
		 
		 int area = r1.getArea();
		 System.out.println("면적:" + area);
		} catch (InputMismatchException e) {
			System.out.println("너비와 높이는 정수값을 입력해주세요.");
		}
		 scanner.close();
	}

}
