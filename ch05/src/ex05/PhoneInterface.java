package ex05;

public interface PhoneInterface {
	public static final int TIMEOUT = 10000; //상수
	//추상메서드
	public void sendCall();
	public void receiveCall();
	default void printLogo() {
		System.out.println("*** Phone ***");
	}
}
