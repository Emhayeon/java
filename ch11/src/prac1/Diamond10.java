package prac1;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Diamond10 extends JFrame{
	
	public Diamond10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ColorArc3");
		setSize(500, 500);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	public class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int width = this.getWidth();
			int height = this.getHeight();
			
			int[] x = {width/2,0,width/2,width};
			int[] y = {0,height/2,height,height/2};
			g.drawPolygon(x,y,x.length);
			
			int xs = (int)this.getWidth()/30;
			int ys = (int)this.getHeight()/30;
			g.drawPolygon(x,y,x.length);
			
			for(int i =1; i<10; i++) {
				y[0]+=ys;
				x[1]+=xs;
				y[2]-=ys;
				x[3]-=xs;
				g.drawPolygon(x,y,x.length);
			}
			


		}
	}
	public static void main(String[] args) {
		new Diamond10();
	}

}
