package ex03;

import java.util.Scanner;

public class Prac08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("커피를 주문하세요>>");
		String coffe = scanner.next();
	    int count = scanner.nextInt();
		
	    switch(coffe) {
		case "에스프레소":
			System.out.println((2000 * count) + "원입니다.");
			break;
		case "아메리카노":
			System.out.println((2500 * count) + "원입니다.");
			break;
		case "카푸치노":
			System.out.println((3000 * count) + "원입니다.");
			break;
		case "카페라떼":
			System.out.println((3500 * count) + "원입니다.");
			break;
		default:
			System.out.println("없는 메뉴입니다.");
			break;
			
			
		
		}
		
	    scanner.close();			
	}

}
