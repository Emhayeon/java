package ex02;

import javax.swing.JLabel;

public class TimerThread extends Thread{
	
	private JLabel label;
	
	
	public TimerThread(JLabel label) {
		this.label = label;
	}
	@Override
	public void run() {
		while(true) {
			
			try {
				
				Thread.sleep(1000);
				String text = label.getText();
				int number = Integer.parseInt(text);
				number++;
				String strNumber = String.valueOf(number);
				label.setText(strNumber);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
