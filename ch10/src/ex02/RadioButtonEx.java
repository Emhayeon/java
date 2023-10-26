package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame implements ItemListener{
	private Container con = getContentPane();
	
	public RadioButtonEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("라디오 버튼 예제");
		setSize(300,200);
		
		JRadioButton rdoApple = new JRadioButton("사과");
		JRadioButton rdoPear = new JRadioButton("배",true);
		JRadioButton rdoCherry = new JRadioButton("체리");
		JRadioButton rdoPhone = new JRadioButton("전화",new ImageIcon("images/normalIcon.gif"));
		
		rdoPhone.setSelectedIcon(new ImageIcon("images/pressedIcon.gif"));
		
		con.setLayout(new FlowLayout());
		con.add(rdoApple);
		con.add(rdoPear);
		con.add(rdoCherry);
		con.add(rdoPhone);
		
		ButtonGroup group = new ButtonGroup();//다 선택안되고 하나만 선택되게함
		group.add(rdoApple);//체크박스랑 차이점 그룹으로 묶는거 차이남
		group.add(rdoPear);
		group.add(rdoCherry);
		
		rdoApple.addItemListener(this);
		rdoPear.addItemListener(this);
		rdoCherry.addItemListener(this);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new RadioButtonEx();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
//		System.out.println(e);//이벤트 2번 발생 체크된거해제 선택한거
		int state = e.getStateChange();
		if (state == ItemEvent.SELECTED) { //선택된거만 작업하고 싶을때
			Object obj = e.getItem();
			String text = ((JRadioButton)obj).getText();
			System.out.println(text + "이(가) 선택됐어요.");
		}
		
	}

}
