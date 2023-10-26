package prac04;

import java.util.Scanner;

public class PhoneManager {
	private Scanner scanner = new Scanner(System.in);
	private Phone[] phones; //null
	private static PhoneManager instance = new PhoneManager();
	private PhoneManager() { }
	
	public static PhoneManager getInstance() {
		return instance;
	}
	
	private void setCount() {
		System.out.print("인원수>>");
		int count = scanner.nextInt();
		phones = new Phone[count];
	}
	
	private void inputData() {
		for (int i = 0; i < phones.length; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
			String name = scanner.next();
			String tel = scanner.next();
			Phone p = new Phone(name, tel);
			phones[i] = p;
		}
		
		System.out.println("저장되었습니다...");
	}//inputData
	
	
	private void search() {
		while (true) {
			System.out.print("검색할 이름>>");
			String name = scanner.next();
			if (name.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				}
			String tel = getTel(name);
			if(tel != null) {
					System.out.println(name + "의 번호는"+ tel +"입니다.");
				}else {
					System.out.println(name +"(이)가 없습니다.");
				}
			}
/*			for(Phone phone : phones) {
				String seachName = phone.getName();
				if(name.equals(seachName)) {//name이랑seachName같은지 비교
					String tel = phone.getTel();
					System.out.println(name + "의 번호는"+ tel +"입니다.");
			
				}
			}*/
		}
	
		private String getTel(String name) {
			for (Phone phone : phones) {
				 if( phone.getName().equals(name)) {
					 return phone.getTel();
				 	}
				}
			return null;
			}
		public void run() {
			setCount();
			inputData();
			search();
		}
	
}