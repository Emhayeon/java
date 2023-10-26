package ex02;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyCalcilator calcilator = new MyCalcilator();
		System.out.println("*** 간단 계산기 ***");
		System.out.print("숫자1: ");
		calcilator.x = scanner.nextInt();
		System.out.print("숫자2: ");
		calcilator.y = scanner.nextInt();
		System.out.println("덧셈: "+ calcilator.x + "+" +calcilator.y + " = " + calcilator.add());
		System.out.println("뺄셈: "+ calcilator.x + "-" +calcilator.y + " = " + calcilator.sub());
		System.out.println("곱셈: "+ calcilator.x + "*" +calcilator.y + " = " + calcilator.mul());
		System.out.println("나눗셈: "+ calcilator.x + "/" +calcilator.y + " = " + calcilator.div());
		System.out.println("나머지: "+ calcilator.x + "%" +calcilator.y + " = " + calcilator.mod());
		
		scanner.close();		

	}

}
