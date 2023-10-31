package oc;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingImageEx extends JFrame {
	private Container con = getContentPane();
	private ImageIcon iconCat = new ImageIcon("images/cat2.jpg");
	private ImageIcon iconHeart = new ImageIcon("images/heart.png");
	private JLabel lblHello = new JLabel(iconCat);
	private MonsterLabel lblMonster = new MonsterLabel(iconHeart);
	private static final int MOVE_UNIT = 10;
	
	public FlyingImageEx() {
		super("키보드로 이미지 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setTitle("키보드로 레이블 움직이기");
		setSize(500, 500);
		setVisible(true);
		
		// (50, 50)의 좌표에 레이블 추가
		con.setLayout(null);
		// 레이블 위치(50, 50), 크기(100 x 30), 색상(노란색)
		lblHello.setBounds(50, 50, 48, 48);
		lblMonster.setBounds(200, 200, 48, 48);
		// lblHello.setOpaque(true);
		lblHello.setBackground(Color.YELLOW);
		// 컨테이너에 레이블 달기
		con.add(lblHello);
		con.add(lblMonster);
		// 컨테이너에 키리스너 달기
		con.addKeyListener(new MyKeyAdapter());
		// 컨테이너에 포커스 작업
		con.setFocusable(true);
		con.requestFocus();
		
		Thread th = new Thread(lblMonster);
		th.start();
	}
	
	// 키어댑터를 상속받은 MyKeyAdapter 클래스
	class MyKeyAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			int x = lblHello.getX();
			int y = lblHello.getY();
			int maxX = con.getWidth() - lblHello.getWidth();
			int maxY = con.getHeight() - lblHello.getHeight();
			
			switch (keyCode) {
			case KeyEvent.VK_UP:
				y -= MOVE_UNIT;
				if (y < 0) {
					y = 0;
				}
				break;
			case KeyEvent.VK_DOWN:
				y += MOVE_UNIT;
				if (y > maxY) {
					y = maxY;
				}
				break;
			case KeyEvent.VK_LEFT:
//				lblHello.setIcon(iconLeft);
				x -= MOVE_UNIT;
				if (x < 0) {
					x = 0;
				}
				break;
			case KeyEvent.VK_RIGHT:
				lblHello.setIcon(iconCat);
				x += MOVE_UNIT;
				if (x > maxX) {
					x = maxX;
				}
				break;
				
			}
			
			lblHello.setLocation(x, y);
		}
		
	}

	public static void main(String[] args) {
		new FlyingImageEx();

	}
	
	public class MonsterLabel extends JLabel implements Runnable {
		private static final int MOVE_UNIT = 5;
		public MonsterLabel(ImageIcon icon) {
			super(icon);
		}
		
		@Override
		public void run() {
			while (true) {
				int helloX = lblHello.getX();
				int helloY = lblHello.getY();
				int monsterX = this.getX();
				int monsterY = this.getY();
				
				int x = monsterX;
				int y = monsterY;
				if (helloX > monsterX) {
					x = monsterX + MOVE_UNIT;
				} else if (helloX < monsterX) {
					x = monsterX - MOVE_UNIT;
				}
				if (helloY > monsterY) {
					y = monsterY + MOVE_UNIT;
				} else if (helloY < monsterY){
					y = monsterY - MOVE_UNIT;
				}
				
				
				this.setLocation(x, y);
				if(helloX - 35 <= x && x <= helloX + 35 || helloY - 35 <= y && y <=helloY + 35) {
					return;
				}
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}