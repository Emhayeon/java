package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JCheckBoxEx extends JFrame implements ActionListener{
	
	private Container con =getContentPane();
	private String[] names = {"사과","배","체리"};
	private JCheckBox[] checks = new JCheckBox[names.length];
	
	public JCheckBoxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("체크박스 예제");
		setSize(300,200);
		setUI();
		
		
		setVisible(true);
	}
	private void setUI() {
		con.setLayout(new FlowLayout());
		for(int i = 0;  i < checks.length; i++) {
			if(!names[i].equals("배")) {
			checks[i] = new JCheckBox(names[i]);
			} else {
				checks[i] = new JCheckBox(names[i],true);
			}
			checks[i].addActionListener(this);//new 하면 리스너 3개 만들어짐
			
			con.add(checks[i]);
		}
		
	}
	public static void main(String[] args) {
		new JCheckBoxEx();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

}
