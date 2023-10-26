package ex05;

public class PhoneMain {

	public static void main(String[] args) {
		//PhoneInterface pi = new PhoneInterface();
		//-> 인터페이스는 객체 생성 불가
		
		SmartPhone phone1 = new SmartPhone();
		phone1.sendCall();
		phone1.receiveCall();
		
		
		//인터페이스를 상위타입으로 사용가능
		PhoneInterface phone2 = new SmartPhone();
		phone2.sendCall();
		phone2.receiveCall();
		//phone2.calculate(); x
		
		CalcInterface phone3 = new SmartPhone(); //phone3는 실제는 SmartPhone인데 CalcInterface로바라봄
		phone3.calculate();
		/*
		phone3.sendCall(); x
		phone3.receiveCall(); x
		*/ 
	}

}
