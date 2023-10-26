package ver03;

import java.util.Scanner;

public class PhoneBookMain {
	

	public static void main(String[] args) {
		
//		int choiceNum=0; //whil(true)안하고 변수 빼고해도됨(choiceNum!=3) -다시
		
		System.out.println("====전화번호부ver03=====");
		
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
			case 1:
				System.out.print("이름: ");
				String name = scanner.nextLine();
				System.out.print("전번: ");
				String tel = scanner.nextLine();				
				System.out.print("생일: ");
				String birth = scanner.nextLine();
				System.out.println("-----------------");
					
				PhoneInfo info = new PhoneInfo(name, tel, birth);//다시
				book.addInfo(info);
					
				break;
				
			case 2:
				book.showAll();
				break;
					
			case 3:
				System.out.println("=====프로그램 종료=====");
				scanner.close();
				System.exit(0);
				break;
					
			}	
			
		}//	while
			
	}

}
