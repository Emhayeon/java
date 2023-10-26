package ex05;

public class SmartPhone implements PhoneInterface, CalcInterface {

	@Override
	public void sendCall() {
		System.out.println("전화를 겁니다.");

	}

	@Override
	public void receiveCall() {
		System.out.println("전화를 받습니다.");

	}

	@Override
	public void calculate() {
		System.out.println("계산을 합니다.");
		
	}

}
