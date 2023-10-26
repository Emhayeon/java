package prac02;

import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Phone[] phones = new Phone[2];//null이 2개 들어있음
		
		for(int i = 0; i < phones.length; i++) {
			System.out.print("이름과 전화번호 입력 >>");
			String name = scanner.next();
			String tel = scanner.next();
			phones[i] = new Phone(name, tel);
		}
		
		for(Phone phone : phones) {
			//Phone phone = phones[0] ..1 이 공식이 숨어있음
			String name = phone.getName();
			String tel = phone.getTel();
			System.out.println(name + "의 번호 " + tel);
		}
		scanner.close();
	}

}
/*main 만들기*/