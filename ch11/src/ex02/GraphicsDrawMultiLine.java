package ex02;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawMultiLine extends JFrame {
	private PaintPanel paintPanel = new PaintPanel();
	private Point startPoint = new Point();
	private Point endPoint = new Point();
	public GraphicsDrawMultiLine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("여러개의 선 그리기");
		setSize(500, 500);
		setContentPane(paintPanel);
		setVisible(true);
	}
	
	public class PaintPanel extends JPanel {
		private MyMouseAdapter adapter = new MyMouseAdapter();
		private Vector<Point> vecStart = new Vector<>();
		private Vector<Point> vecEnd = new Vector<>();
		
		public PaintPanel() {
			addMouseListener(adapter);
			addMouseMotionListener(adapter);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 벡터에 담겨 있는거 그리기
			for (int i = 0; i < vecEnd.size(); i++) {
				Point sPoint = vecStart.get(i);
				Point ePoint = vecEnd.get(i);
				g.drawLine(sPoint.x, sPoint.y, ePoint.x, ePoint.y);
			}
			
			// 현재 그리기
			g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		}
		
		public class MyMouseAdapter extends MouseAdapter {
			@Override
			public void mousePressed(MouseEvent e) {
				startPoint = e.getPoint();
				vecStart.add(startPoint);
				System.out.println("s:" + vecStart);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				endPoint = e.getPoint();
				paintPanel.repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				endPoint = e.getPoint();
				vecEnd.add(endPoint);
				System.out.println("e:" + vecEnd);
			}
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawMultiLine();

	}

}