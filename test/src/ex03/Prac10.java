package ex03;

import java.util.Scanner;

public class Prac10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("커피 주문하세요>>");
		String coffee = scanner.next();//문자
		int count = scanner.nextInt();//정수
		//System.out.println("coffee: "+ coffee);
		//System.out.println("count: "+ count);
		//에스프리소:2000 아메리카노 2500 카푸 3000 카페 3500
		switch (coffee) {
		case "에스프레소":
			//카운트가 10잔 이상
			if (count >= 10) {
				System.out.println((int)((count * 2000) * 0.95)+"원 입니다.");
			} else {
				System.out.println((2000 * count) +"원 입니다.");
			}
			
			break;
		case "아메리카노":
			System.out.println((2500 * count) +"원 입니다.");
			break;
		case "카푸치노":
			System.out.println((3000 * count) +"원 입니다.");
			break;
		case "카페라떼":
			System.out.println((3500 * count) +"원 입니다.");
			break;
			
		

		}
		scanner.close();
	}
}