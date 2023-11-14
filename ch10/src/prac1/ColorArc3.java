package prac1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorArc3 extends JFrame {
	public ColorArc3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3원 그리기");
		setSize(500, 500);
		setContentPane(new PaintPanel());
		setVisible(true);
	}
	
	public class PaintPanel extends JPanel {
		/*
		private Color[] colors = {
				Color.RED, Color.BLUE, Color.YELLOW, Color.MAGENTA,
				Color.GREEN
		};
		*/
		private int startAngle = 90;
		private static final int CIRLE_SIZE = 200;
		private static final int COUNT = 10;
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int panelX = this.getWidth() / 2;
			int panelY = this.getHeight() / 2;
			int centerX = panelX - (CIRLE_SIZE / 2);
			int centerY = panelY - (CIRLE_SIZE / 2);
			for (int i = 0; i < COUNT; i++) {
				int red = (int)(Math.random() * 256);
				int green = (int)(Math.random() * 256);
				int blue = (int)(Math.random() * 256);
				int rotate = 360 / COUNT;
				g.setColor(new Color(red, green, blue));
				g.fillArc(centerX, centerY, 200, 200, startAngle, rotate);
				startAngle += rotate;
			}
			
		}
	}

	public static void main(String[] args) {
		new ColorArc3();
	}

}