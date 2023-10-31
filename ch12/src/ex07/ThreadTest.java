package ex07;

public class ThreadTest {
	
	public static void main(String[] args) {
		MyThread th1 = new MyThread("스레드-1"); // 10
		MyThread th2 = new MyThread("스레드-2"); // 5
		// th1.setPriority(Thread.MAX_PRIORITY);
		Board board = new Board();
		// 두개의 스레드가 같은 Board 객체를 가지고 있다.
		th1.setBoard(board);
		th2.setBoard(board);
		th1.start();
		th2.start();
	}
	
	static class MyThread extends Thread {
		private Board board;
		public void setBoard(Board board) {
			this.board = board;
		}
		
		public MyThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				String name = Thread.currentThread().getName();
				int number = board.getNumber();
				number++;
				try {
					if (name.equals("스레드-1")) {
						Thread.sleep(100);
					} else {
						Thread.sleep(200);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				board.setNumber(number);
				System.out.println(name + ":" + number);
			}
		}
	}
}

class Board {
	private int number = 0;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}