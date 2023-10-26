package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		
		
		PhoneInfo info1 = new PhoneInfo("한현수","010-1111-1111");
		book.addInfo(info1);
		
		PhoneInfo info2 = new PhoneInfo("김동영","010-2222-2222","2000.01.01");
		book.addInfo(info2);
		
		book.showAll();
		
		
		//for (int i = 0; i < infos.lengrh; i++)
		//for(PhoneInfo aInfo : infos) {
		//	aInfo.showInfo(); //infos에서 하나씩 꺼낸다
		//}
		
		/*
		 [출력결과]
		 이름:한현수
		 전번:010-1111-1111
		 -------------------
		 이름:김동영
		 전번:010-2222-2222
		 생일:2000.01.01
		 ------------------
		 */

	}

}
