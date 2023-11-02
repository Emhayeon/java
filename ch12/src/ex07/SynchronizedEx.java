package ex07;

public class SynchronizedEx {

	public static void main(String[] args) {
		SharedPrinter printer = new SharedPrinter();
		
		String[] data1 = {
				"동해물과", "백두산이", "마르고", "닳도록",
				"하느님이", "보우하사", "우리나라", "만세"
		};
		
		String[] data2 = {
				"남산위에", "저소나무", "철갑을", "두른듯",
				"바람서리", "불변함은", "우리", "기상일세"
		};
		
		WorkerThread th1 = new WorkerThread("th1", printer, data1);
		WorkerThread th2 = new WorkerThread("th2", printer, data2);
		th1.start();
		th2.start();

	}

}

class SharedPrinter {
	public  synchronized   void print(String text) {
		System.out.print(Thread.currentThread().getName() + ":");
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

class WorkerThread extends Thread {
	private SharedPrinter printer;
	private String[] text;
	
	public WorkerThread(String name, SharedPrinter printer, 
			String[] text) {
		super(name);
		this.printer = printer;
		this.text = text;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < text.length; i++) {
			printer.print(text[i]);
		}
	}
	
}