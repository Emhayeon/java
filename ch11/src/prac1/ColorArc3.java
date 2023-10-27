package prac1;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;





@SuppressWarnings("serial")
public class ColorArc3 extends JFrame{
	
	
	
	public ColorArc3() {
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
		
			
			g.setColor(Color.RED);
			g.fillArc(100, 100, 300, 300, 90, 120);
			g.setColor(Color.BLUE);
			g.fillArc(100, 100, 300, 300, 210, 120);
			g.setColor(Color.YELLOW);
			g.fillArc(100, 100, 300,300, 330, 120);
			
			
		}
		
	}
	public static void main(String[] args) {
		new ColorArc3();
	}

}
