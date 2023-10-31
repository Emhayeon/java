package prac04; //선생님이 하신거

import java.awt.Container;
import java.awt.Font;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DigitalClockEx extends JFrame {
	private Container con = getContentPane();
	private ClockLabel label = new ClockLabel();
	
	public DigitalClockEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("러너블 레이블");
		setSize(300, 300);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label);
		setVisible(true);
		
		Thread th = new Thread(label);
		th.start();
	}
	
	// 스레드 기능이 있는 레이블
	public class ClockLabel extends JLabel implements Runnable {
		
		private String make2digits(int value) {
			String strValue = String.valueOf(value);
			if (value < 10) {
				strValue = "0" + value;
			}
			return strValue;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					
					Calendar c = Calendar.getInstance();
					int hour = c.get(Calendar.HOUR_OF_DAY);
					int minute = c.get(Calendar.MINUTE);
					int second = c.get(Calendar.SECOND);
					StringBuffer sb = new StringBuffer();
					sb.append(make2digits(hour));
					sb.append(":");
					sb.append(make2digits(minute));
					sb.append(":");
					sb.append(make2digits(second));
					this.setText(sb.toString());
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new DigitalClockEx();

	}

}