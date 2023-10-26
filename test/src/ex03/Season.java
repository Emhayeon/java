package ex03;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {
		// 스캐너 생성
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("월(1~12)을 입력하세요: ");
		int month = scanner.nextInt();
		
		switch (month) {
		case 3: case 4: case 5:
			System.out.println("봄");
			break;
		case 6: case 7: case 8:
			System.out.println("여름");
			break;
		case 9: case 10: case 11:
			System.out.println("가을");
			break;
		case 12: case 1: case 2:
			System.out.println("겨울");
			break;
		default:
			System.out.println("잘못 입력");
		}
		
		//스캐너 닫기
		scanner.close();
		
		
		

	}

}
