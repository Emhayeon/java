package ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;






@SuppressWarnings("serial")
public class GraphicsDrawShapeMouseExME extends JFrame implements ActionListener{
	private String[] figureName = {"선","원","사각형"};
	private String[] colorName = {"빨강","파랑","보라"};
	private JRadioButton[] rdofigure= new JRadioButton[figureName.length];
	private JRadioButton[] rdocolor =new JRadioButton[colorName.length];
	private Container con = getContentPane();
	private MyMouseAdapter adapter = new MyMouseAdapter();
	private Point point1 =new Point();
	private Point point2 =new Point();
	private PaintPanel paintpanel = new PaintPanel();
	private int figure=0;
	private static final int LINE=0;
	private static final int OVAL=1;
	private static final int RECT=2;
	private int color=0;
	private static final int RED=0;
	private static final int BLUE=1;
	private static final int MAGENTA=2;
	
	
	//North
	 JPanel pnlNorth = new JPanel();
	 
	 
	
	// Center
	 JPanel pnlCenter = new JPanel();
	
	 //South
	 JPanel pnlSouth = new JPanel();
	 
	 
	 
	public GraphicsDrawShapeMouseExME() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("도형 그리기");
		setSize(500, 500);
		setNorth();
		setSouth();
		setCenter();
		setListener();
	
		
		setVisible(true);
	}
	
	private void setListener() {
		for(int i=0; i<rdofigure.length; i++) {
			rdocolor[i].addActionListener(this);
			rdofigure[i].addActionListener(this);
		}
		paintpanel.addMouseListener(adapter);
		paintpanel.addMouseMotionListener(adapter);
	}
	public class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			point1 = e.getPoint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			point2 = e.getPoint();
			paintpanel.repaint();
		}
	}

	public class PaintPanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
//			g.drawLine(50, 50, 100, 200);
			switch (figure) {
			case LINE:
				g.drawLine(point1.x, point1.y, point2.x, point2.y);
				break;
			case OVAL:
				g.drawOval(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
				break;
			case RECT:
				g.drawRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
				break;
				
			}
			switch (color) {
			case RED: 
				g.setColor(Color.RED);
				break;
			case BLUE:
				g.setColor(Color.BLUE);
				break;
			case MAGENTA: 
				g.setColor(Color.MAGENTA);
				break;
				
			}
			
			System.out.println("도형:" + figure + ", 색:" + color);
		}
	}
	private void setCenter() {
		con.add(paintpanel,BorderLayout.CENTER);
		
	}


	private void setSouth() {
		con.add(pnlSouth,BorderLayout.SOUTH);
		pnlSouth.setBackground(Color.CYAN);
		ButtonGroup grpColor = new ButtonGroup();
		for(int i=0; i<rdocolor.length; i++) {
		 rdocolor[i] = new JRadioButton(colorName[i]);
		 grpColor.add(rdocolor[i]);
		 pnlSouth.add(rdocolor[i]);
		}
		rdocolor[0].setSelected(true);
		
		
	}


	private void setNorth() {
		con.add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.setBackground(Color.YELLOW);
		ButtonGroup grpFigure = new ButtonGroup();
		for(int i=0; i<rdofigure.length; i++) {
			rdofigure[i]= new JRadioButton(figureName[i]);
			grpFigure.add(rdofigure[i]);
			pnlNorth.add(rdofigure[i]);
			
		}
		rdofigure[0].setSelected(true);
		
		
		
	}


	public static void main(String[] args) {
		new GraphicsDrawShapeMouseExME();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		for(int i=0; i<rdofigure.length; i++) {
			if(obj==rdofigure[i]) {
				figure = i; //rdofigure가 0번째이면 figure도 0번째다 라고 설정하는거
				break;
			}
		}
		for (int i = 0; i < rdocolor.length; i++) {
			if (obj == rdocolor[i]) {
				color = i;
				break;
			}
		}
	
		 
		 
	}

}
