package ex03;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MouseAdapterEx extends JFrame{
	private Container con = getContentPane();
	
	
	public MouseAdapterEx() {
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("마우스 어댑터 예제");
	setSize(500,500);
	setVisible(true);
	con.addMouseListener(new MyMouseAdapter());//익명내부클래스형태
	
	
	}
	
	public class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.printf("(%d,%d)\n",x,y);
			
		}
	}
	
	
	public static void main(String[] args) {
		new MouseAdapterEx();

	}

}
