package ex03;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자1: ");
		int num1 = scanner.nextInt();
		System.out.print("숫자2: ");
		int num2 = scanner.nextInt();
		System.out.print("연산자: ");
		String Oper =scanner.next();
		
		
		switch(Oper) {
		case "+":
			System.out.println("덧셈결과:" + num1 + " + " + num2 + " = " + (num1+num2));
			break;
		case "-":
			System.out.println("뺄셈결과 " + num1 + " - " + num2 + " = " + (num1-num2));
			break;
		case "*":
			System.out.println("곱셈결과 " + num1 + " * " + num2 + " = " + (num1*num2));
			break;
		case "/": 
			System.out.println("나눗셈결과 " + num1 + " / " + num2 + " = " + (num1/num2));
			break;
		case "%":
			System.out.println("나머지결과 " + num1 + " % " + num2 + " = " + (num1%num2));
			break;
		default:
			System.out.println("잘못 입력했어요.");
			break;
			
		
		}
		scanner.close();

	}

}
