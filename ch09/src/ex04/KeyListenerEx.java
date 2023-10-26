package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerEx extends JFrame{
	private Container con = getContentPane();
	private JLabel label = new JLabel("<Enter>키로 배경색이 바뀝니다.");
	
	public KeyListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("키 리스너 예제");
		setSize(500,500);
		setVisible(true);
		con.setLayout(new FlowLayout());
		con.add(label);
		
		//레이블 기본상태 -투명한 상태라 색이 적용이 안됨 그래서 불투명 상태로 바꿔줘야함
		label.setOpaque(true); //불투명상태로 바꾸기
		label.setBackground(Color.YELLOW);
		
		con.addKeyListener(new MyKeyAdapter());
		
		//키 이벤트를 받을 조건
		con.setFocusable(true);
		con.requestFocus();
		
	}
	
	class MyKeyAdapter extends KeyAdapter{

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("문자 키 타이핑");
			char ch = e.getKeyChar();//문자얻어내기 ch는기본타입
			if(ch == '\n') {
				int r =(int)(Math.random()*256);
				int g =(int)(Math.random()*256);
				int b =(int)(Math.random()*256);
				Color newColor = new Color(r, g, b); //rgb(red green blue)
				con.setBackground(newColor);
				label.setText("red=" + r +", green=" + g + ", blue=" + b);
			} else if(ch == 'q') {
				System.exit(0);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("키보드 눌림");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("키보드 뗌");
		}
		
	}
	
	public static void main(String[] args) {
		new KeyListenerEx();

	}

}
