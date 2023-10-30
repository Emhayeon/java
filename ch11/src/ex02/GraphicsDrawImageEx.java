package ex02;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawImageEx extends JFrame{

	public GraphicsDrawImageEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이미지 그리기");
		setSize(500, 500);
		setContentPane(new MyPanel());
		
		setVisible(true);
	}
	public class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/cat.png");
		private Image image = icon.getImage();
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
//			g.drawImage(image, 20, 20, this); //원본크기로 그림
//			g.drawImage(image, 20, 20, 400, 300, this);//400*300
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);//패널크기에 맞춤
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx();
	}

}
