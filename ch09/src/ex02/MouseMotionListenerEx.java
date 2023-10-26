package ex02;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MouseMotionListenerEx extends JFrame{
	
	Container con = getContentPane();
	JLabel lblHello = new JLabel("Hello");
	MyMouseMotionListener lis = new MyMouseMotionListener();
	
	public MouseMotionListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 모션 리스너 예제");
		setSize(500,500);
		
		con.setLayout(null);
		lblHello.setBounds(10, 10, 100, 30);
		con.add(lblHello);
		con.addMouseMotionListener(lis);
		
		setVisible(true);
		
	}	
	//내부클라스
	class MyMouseMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			lblHello.setLocation(x, y);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("mouseMoved");
		}

		

	
	}
	
	
	public static void main(String[] args) {

		new MouseMotionListenerEx();

	}

}
