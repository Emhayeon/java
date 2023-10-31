package prac04;//내가한거

import java.awt.Container;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Digitalclock extends JFrame{
	
	private Container con = getContentPane();
	private DigitalclockLable label = new DigitalclockLable();

	
	public Digitalclock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("디지털 시계");
		setSize(300, 300);
		con.add(label);
		label.setFont(new Font("맑은 고딕",Font.BOLD,50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Thread th = new Thread(label);
		th.start();
		
		
		
		
		setVisible(true);
	}
	
	public class DigitalclockLable extends JLabel implements Runnable{
	

		@Override
		public void run() {
			while(true) {
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int min = c.get(Calendar.MINUTE);
				int second = c.get(Calendar.SECOND);
				String clockText = Integer.toString(hour);
				clockText = clockText.concat(":");
				clockText = clockText.concat(Integer.toString(min));
				clockText = clockText.concat(":");
				clockText = clockText.concat(Integer.toString(second));
				
				label.setText(clockText);
			}
			
			
		}

		
	}
	public static void main(String[] args) {
		new Digitalclock();
	}

}
