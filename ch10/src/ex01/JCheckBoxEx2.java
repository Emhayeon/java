package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JCheckBoxEx2 extends JFrame implements ItemListener{
	
	private Container con =getContentPane();
	private String[] names = {"사과","배","체리"};
	private JCheckBox[] checks = new JCheckBox[names.length];
	
	public JCheckBoxEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("체크박스 예제 2");
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
			checks[i].addItemListener(this);//new 하면 리스너 3개 만들어짐
			
			con.add(checks[i]);
		}
		
	}
	public static void main(String[] args) {
		new JCheckBoxEx2();

	}
	
	@Override//아이템 상태가 변경됬을때 실행됨
	public void itemStateChanged(ItemEvent e) {
//		System.out.println(e);
		int state = e.getStateChange();
//		System.out.println(state);
		if (state == ItemEvent.SELECTED) {
			Object obj = e.getItem();
			String text = ((JCheckBox)obj).getText();
			System.out.println(text + "이(가) 체크됨");
		}
		
	}

}
