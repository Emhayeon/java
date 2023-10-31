package ex03;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable{
	
	
	private JLabel label;
	
	public TimerRunnable(JLabel label) {
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
