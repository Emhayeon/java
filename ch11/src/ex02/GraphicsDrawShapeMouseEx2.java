package ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ex02.GraphicsDrawOvalMouseEx.MyMouseAdapter;




@SuppressWarnings("serial")
public class GraphicsDrawShapeMouseEx2 extends JFrame implements ActionListener{
	private Container con = getContentPane();
	private MyMouseAdapter adapter = new MyMouseAdapter();
	private int figure =0;
	private static final int Line =1;
	private static final int Oval =2;
	private static final int Square =3;
	

	
	
	//North
	 JPanel pnlNorth = new JPanel();
	 JRadioButton rdoLine =new JRadioButton("선",true);
	 JRadioButton rdoOval =new JRadioButton("원");
	 JRadioButton rdoSquare =new JRadioButton("사각형");
	 
	
	// Center
	 JPanel pnlCenter = new JPanel();
	
	 //South
	 JPanel pnlSouth = new JPanel();
	 JRadioButton rdoRed =new JRadioButton("빨강",true);
	 JRadioButton rdoBlue =new JRadioButton("파랑");
	 JRadioButton rdoPurple =new JRadioButton("보라");
	 
	 
	public GraphicsDrawShapeMouseEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("도형 그리기");
		setSize(500, 500);
		setNorth();
		setSouth();
		setCenter();
		setListener();
		
		ButtonGroup groupFigure = new ButtonGroup();
		groupFigure.add(rdoLine);
		groupFigure.add(rdoOval);
		groupFigure.add(rdoSquare);
		
		ButtonGroup groupColor = new ButtonGroup();
		groupColor.add(rdoRed);
		groupColor.add(rdoBlue);
		groupColor.add(rdoPurple);
		
		setVisible(true);
	}
	
	private void setListener() {
		rdoLine.addActionListener(this);
		rdoOval.addActionListener(this);
		rdoSquare.addActionListener(this);
		rdoRed.addActionListener(this);
		rdoBlue.addActionListener(this);
		rdoPurple.addActionListener(this);
		
	}
	public class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			e.getPoint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			
		}
	}

	public class PaintPanel extends JPanel{
		public PaintPanel() {
			
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(80, 80, 300, 300);
			switch (figure) {
			case Line :
				g.drawLine(80, 80, 300, 300);
				break;
			case Oval :
				  g.drawOval(100, 100, 200, 200);
				break;
			case Square :
				  g.drawRect(50, 50, 200, 200);
				break;
			}
			
		}
	}
	private void setCenter() {
		con.add(new PaintPanel(),BorderLayout.CENTER);
		
	}


	private void setSouth() {
		con.add(pnlSouth,BorderLayout.SOUTH);
		pnlSouth.setBackground(Color.CYAN);
		pnlSouth.add(rdoRed);
		pnlSouth.add(rdoBlue);
		pnlSouth.add(rdoPurple);
		
		
		
	}


	private void setNorth() {
		con.add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.setBackground(Color.YELLOW);
		pnlNorth.add(rdoLine);
		pnlNorth.add(rdoOval);
		pnlNorth.add(rdoSquare);
		
		
	}


	public static void main(String[] args) {
		new GraphicsDrawShapeMouseEx2();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==rdoLine) {
			figure=Line;
		}else if(e.getSource() ==rdoOval) {
			figure=Oval;
		}else if(e.getSource() ==rdoSquare) {
			figure=Square;
		}
		 repaint();
		 
		 
	}

}
