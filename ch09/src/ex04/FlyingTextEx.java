package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx extends JFrame{
	private Container con = getContentPane();
	private JLabel lblHello =new JLabel("Hello");
	private static final int MOVE_UNIT =10;
	
	public FlyingTextEx() {
		super("키보드로 레이블 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setTitle("키보드로 레이블 움직이기");
		setSize(500,500);
		setVisible(true);
		
		con.setLayout(null);
		
		lblHello.setBounds(50, 50, 30, 15);
//		lblHello.setOpaque(true);
		lblHello.setBackground(Color.YELLOW);
		
		// 컨테이너에 키리스너 달기
		con.addKeyListener(new MyKeyAdapter());
		
		con.add(lblHello);
		con.setFocusable(true);
		con.requestFocus();
		
		
		
		
	}
	
	class MyKeyAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			
			int x=lblHello.getX();
			int y=lblHello.getY();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				lblHello.setLocation(x, y - MOVE_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				lblHello.setLocation(x, y + MOVE_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				lblHello.setLocation(x - MOVE_UNIT, y);
				break;
			case KeyEvent.VK_RIGHT:
				lblHello.setLocation(x + MOVE_UNIT, y );
				break;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		new FlyingTextEx();

	}

}
