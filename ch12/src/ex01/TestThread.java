package ex01;

public class TestThread {

	public static void main(String[] args) {
		TimerThread th = new TimerThread();
//		th.run();
		th.start();
		
		int counter = 1000;
		while(counter <=100000) {
		try {
			Thread.sleep(100);
			System.out.println(++counter);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		System.out.println("main 종료");
	}

}

class TimerThread extends Thread{
	//스레드의 메인
	@Override
	public void run() {
		//delay(millis)
		int counter = 0;
		while(counter <=100) {
		try {
			Thread.sleep(100);
			System.out.println(++counter);
		} catch (InterruptedException e) {
			e.printStackTrace();
		 }
		}
		System.out.println("run 종료");
	}
}
