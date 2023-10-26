package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneInfo info1 = new PhoneInfo("한현수","010-1111-1111");
		PhoneInfo info2 = new PhoneInfo("김동영","010-2222-2222","2000.01.01");
		
		/*
		info1.showInfo();
		info2.showInfo();
		*/
		
		PhoneInfo[] infos = {info1, info2};//객체 배열
		
		//객체 스와핑 (순서변경)
		PhoneInfo temp = infos[0];
		infos[0] = infos[1];
		infos[1] = temp;
		
		//for (int i = 0; i < infos.lengrh; i++)
		for(PhoneInfo aInfo : infos) {
			aInfo.showInfo(); //infos에서 하나씩 꺼낸다
		}
		
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
