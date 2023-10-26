package ver05;

import java.util.Scanner;

public class PhoneBookMain {
	public static final int INPUT = 1;
	public static final int SHOW_ALL = 2;
	public static final int EXIT = 3;
	public static final int INPUT_TEST_DATA = 99;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhoneBook book = new PhoneBook();
		// scanner.nextInt() - 정수 읽기
		// scanner.nextLine() - 문자열 읽기
		
		System.out.println("===== 전화번호부 ver.05 =====");
		
		while (true) {
			MenuViewer.showMenu();
			System.out.print("선택> ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case INPUT:
				System.out.print("이름: ");
				String name = scanner.nextLine();
				System.out.print("전번: ");
				String phoneNumber = scanner.nextLine();
				System.out.print("생일: ");
				String birthDay = scanner.nextLine();
				PhoneInfo info = new PhoneInfo(name, phoneNumber, birthDay);
				try {
					book.addInfo(info);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("저장 용량이 다 찼어요");
				}
				break;
			case SHOW_ALL:
				book.showAll();
				break;
			case EXIT:
				scanner.close();
				System.out.println("===== 프로그램 종료 =====");
				System.exit(0);
				break;
			case INPUT_TEST_DATA:
				for (int i = 1; i <= 10; i++) {
					PhoneInfo infoTest = 
							new PhoneInfo("이름-" + i,
										  "전번-" + i,
										  "생일-" + i);
					book.addInfo(infoTest);
				}
				
				break;
			}
			
			
		} // while
	} // main
	
	public static void showMenu() { 
		System.out.println("--------------------------");
		System.out.println("1.입력  2.전체조회  3.종료");
		System.out.println("--------------------------");
	}

}