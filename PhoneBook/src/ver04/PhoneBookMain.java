package ver04;

import java.util.Scanner;

public class PhoneBookMain {
	public static final int INPUT = 1;
	public static final int SHOW_ALL = 2;
	public static final int EXIT = 3;
	public static final int INPUT_TEST_DATA = 99;

	public static void main(String[] args) {
		
		//int choiceNum=0; //whil(true)안하고 변수 빼고해도됨(choiceNum!=3) -다시
		
		System.out.println("====전화번호부ver04=====");
		
		PhoneBook book = new PhoneBook();
		
		while(true) { //다시
			System.out.println("---------------------");
			System.out.println("1.입력 2.전체조회 3.종료");
			System.out.println("---------------------");
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("선택> ");
			int choiceNum = scanner.nextInt();
			scanner.nextLine();
			
			switch(choiceNum) {
			case INPUT:
				System.out.print("이름: ");
				String name = scanner.nextLine();
				System.out.print("전번: ");
				String tel = scanner.nextLine();				
				System.out.print("생일: ");
				String birth = scanner.nextLine();
				System.out.println("-----------------");
					
				PhoneInfo info = new PhoneInfo(name, tel, birth);//다시
				try { 
					book.addInfo(info);
				} catch (ArrayIndexOutOfBoundsException e) {
					 System.out.println("저장 용량이 다 찼어요.");
				}	
				break;
				
			case SHOW_ALL:
				book.showAll();
				break;
					
			case EXIT:
				System.out.println("=====프로그램 종료=====");
				scanner.close();
				System.exit(0);
				break;
			case INPUT_TEST_DATA:
				for(int i =1; i<= 10; i++) {
					PhoneInfo infoTest = new PhoneInfo("이름-"+i,"전번-"+i,"생일-"+i);
					book.addInfo(infoTest);
				}
				break;
			}	
			
		}//	while
			
	}

}
