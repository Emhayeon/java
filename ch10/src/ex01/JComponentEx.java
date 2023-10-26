package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JComponentEx extends JFrame{
	private Container con = getContentPane(); 
	JButton button1 = new JButton("Magenta/Yellow Button");
	JButton button2 = new JButton("Disabled Button");
	JButton button3 = new JButton("getX(),getY()");
	
	public JComponentEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("컴포넌트 공통 기능");
		setSize(500,500);
		
		JPanel panel= new JPanel();
		con.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		button1.setBackground(Color.YELLOW);
		button1.setForeground(Color.MAGENTA);
		button1.setFont(new Font("맑은 고딕", Font.ITALIC, 30));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				button2.setEnabled(true);
				
			}
		});
		
		button2.setEnabled(false);//비활성화
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x= button3.getX();
				int y= button3.getY();
				setTitle(x+","+y);
			}
		});
		
		
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new JComponentEx();

	}

}
