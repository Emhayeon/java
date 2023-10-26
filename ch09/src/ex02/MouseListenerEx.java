package ex02;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MouseListenerEx extends JFrame{
	MyMouseListener lis = new MyMouseListener();
	Container con = getContentPane();
	JLabel lblHello = new JLabel("Hello");
	
	public MouseListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 리스너 예제");
		setSize(500,500);
		con.setLayout(null);
		lblHello.setBounds(10,10,100,30);
		con.add(lblHello);
		con.addMouseListener(lis);
		
		setVisible(true);
		
		
	}
	
	//내부 클래스
	@SuppressWarnings("unused")
	private class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");
		}
			
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("mousePressed");
			int x = e.getX();
			int y = e.getY();
			System.out.println("X:"+x+","+"Y:"+y);
			lblHello.setLocation(x, y);
		}
		

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("mouseReleased");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited");
		}
		
	}
	
	
	public static void main(String[] args) {
		new MouseListenerEx();

	}


}
