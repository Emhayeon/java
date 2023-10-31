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
public class GraphicsDrawShapeMouseEx2 extends JFrame implements ActionListener {
	
	private Container con = getContentPane();
	private String[] shapeNames = {"선", "타원", "사각형"};
	private String[] colorNames = {"빨강", "파랑", "보라"};
	private JRadioButton[] rdoShapes = new JRadioButton[shapeNames.length];
	private JRadioButton[] rdoColors = new JRadioButton[colorNames.length];
	private PaintPanel paintPanel = new PaintPanel();
	private static final int LINE = 0;
	private static final int OVAL = 1;
	private static final int RECT = 2;
	private static final int RED = 0;
	private static final int BLUE = 1;
	private static final int MAGENTA = 2;
	private int curShape = LINE;
	private int curColor = RED;
	private MyMouseAdapter adapter = new MyMouseAdapter();
	private Point point1 = new Point();
	private Point point2 = new Point();
	
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
	
	public GraphicsDrawShapeMouseEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("도형 그리기");
		setSize(500, 500);
		setUI();
		setListener();
		setVisible(true);
	}

	private void setListener() {
		for (int i = 0; i < rdoShapes.length; i++) {
			rdoShapes[i].addActionListener(this);
			rdoColors[i].addActionListener(this);
		}
		
		paintPanel.addMouseListener(adapter);
		paintPanel.addMouseMotionListener(adapter);
		
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}

	private void setCenter() {
		con.add(paintPanel);
	}

	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.CYAN);
		ButtonGroup grpColor = new ButtonGroup();
		for (int i = 0; i < rdoColors.length; i++) {
			rdoColors[i] = new JRadioButton(colorNames[i]);
			pnlSouth.add(rdoColors[i]);
			grpColor.add(rdoColors[i]);
		}
		rdoColors[0].setSelected(true);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setNorth() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.YELLOW);
		ButtonGroup grpShape = new ButtonGroup();
		for (int i = 0; i < rdoShapes.length; i++) {
			rdoShapes[i] = new JRadioButton(shapeNames[i]);
			pnlNorth.add(rdoShapes[i]);
			grpShape.add(rdoShapes[i]);
		}
		rdoShapes[0].setSelected(true);
		con.add(pnlNorth, BorderLayout.NORTH);
		
	}
	
	public class PaintPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			switch (curColor) {
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
			
			switch (curShape) {
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
			
			
			System.out.println("도형:" + curShape + ", 색:" + curColor);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawShapeMouseEx2();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for (int i = 0; i < rdoShapes.length; i++) {
			if (obj == rdoShapes[i]) {
				curShape = i;
				break;
			}
		}
		
		for (int i = 0; i < rdoColors.length; i++) {
			if (obj == rdoColors[i]) {
				curColor = i;
				break;
			}
		}
		
	}

}