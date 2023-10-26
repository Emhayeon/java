package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx2 extends JFrame{
	private Container con = getContentPane();
	private JLabel lblHello =new JLabel("Hello");
	private static final int MOVE_UNIT =10;
	
	public FlyingTextEx2() {
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
		
		
		int W=con.getWidth();
		System.out.println("W:"+W); //484
		int H = con.getHeight();
		System.out.println("H:"+H); //461
		
	}
	
	class MyKeyAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			
			int x=lblHello.getX();
			int y=lblHello.getY();
			
			int maxX = con.getWidth() - lblHello.getWidth();
			int maxY = con.getHeight() - lblHello.getHeight();

			/* 소영씨 방식 switch안에 넣어서 해봐
			if(x>484) {
				x=484-lblHello.getWidth();
			}
			if(x<=0) {
				x=0;
			}
			if(y>461) {
				y=461-lblHello.getHeight();
			}
			if(y<=0) {
				y=0;
			}*/
			switch(keyCode) {
			case KeyEvent.VK_UP:
				y -=MOVE_UNIT;
				if(y<0) {
					y=0;
				}
				break;
			case KeyEvent.VK_DOWN:
				y +=MOVE_UNIT;
				if(y>maxY) {
					y=maxY;
				}
				break;
			case KeyEvent.VK_LEFT:
				x -= MOVE_UNIT;
				if(x<0) {
					x=0;
				}
				break;
			case KeyEvent.VK_RIGHT:
				x += MOVE_UNIT;
				if(x>maxX) {
					x=maxX;
				}
				break;
				
			}
			
			lblHello.setLocation(x,y);
		}
	
		
	}
	
	public static void main(String[] args) {
		new FlyingTextEx2();

	}

}
