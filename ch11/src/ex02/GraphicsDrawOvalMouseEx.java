package ex02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawOvalMouseEx extends JFrame {
	private Point point1, point2;
	private PaintPanel paintPanel = new PaintPanel();
	private MyMouseAdapter adapter = new MyMouseAdapter();
	
	public GraphicsDrawOvalMouseEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스로 타원 그리기");
		setSize(500, 500);
		setContentPane(paintPanel);
		paintPanel.addMouseListener(adapter);
		paintPanel.addMouseMotionListener(adapter);
		setVisible(true);
	}
	
	public class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			point1 = e.getPoint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			point2 = e.getPoint();
			paintPanel.repaint();
		}
	}
	
	public class PaintPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			int width = Math.abs(point2.x - point1.x);
			int height = Math.abs(point2.y - point1.y);
			int startX = point1.x;
			int startY = point1.y;
			if (point1.x > point2.x) {
				startX = point2.x;
			}
			if (point1.y > point2.y) {
				startY = point2.y;
			}
			g.drawOval(startX, startY, width, height);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawOvalMouseEx();

	}

}