package prac01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;



@SuppressWarnings("serial")
public class MousePractice extends JFrame{
	MyMouseListener lis = new MyMouseListener();
	Container con = getContentPane();
	JLabel lblbabe = new JLabel("자기야");
	
	public MousePractice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스연습");
		setSize(500, 500);
		
		con.setLayout(new FlowLayout());
		con.add(lblbabe);
		lblbabe.addMouseListener(lis);
		lblbabe.setSize(50,50);//레이블 사이즈 체크
		con.setBackground(Color.GREEN);
		con.addMouseListener(lis);
		con.addMouseMotionListener(lis);
		
		
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	class  MyMouseListener implements MouseListener,MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
			
		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			con.setBackground(Color.GREEN);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();
			if(obj == lblbabe) {
				lblbabe.setText("사랑해");
			} //다시봐  정확하게 범위지정해서 바꾸게함
		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblbabe.setText("자기야");
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			con.setBackground(Color.YELLOW);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new MousePractice();

	}

}
