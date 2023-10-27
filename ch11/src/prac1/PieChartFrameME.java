package prac1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PieChartFrameME extends JFrame implements ActionListener{
	private Container con = getContentPane();
	private String[] fruits = {"apple","cherry","strawberry","prune"};
	private JTextField[] tfFruits = new JTextField[fruits.length];
	private int[] saleCounts = new int [fruits.length];
	private int[] percents = new int [fruits.length];
	private int[] angles = new int [fruits.length];
	
	//North
	JLabel lblApple = new JLabel("apple");
	JLabel lblCherry = new JLabel("cherry");
	JLabel lblStrawberry = new JLabel("strawberry");
	JLabel lblPrune = new JLabel("prune");
	JTextField tfApple =new JTextField(5);
	JTextField tfCherry =new JTextField(5);
	JTextField tfStrawberry =new JTextField(5);
	JTextField tfPrune =new JTextField(5);
	private	JPanel pnlNorth = new JPanel();
	//center
	private JPanel pnlCenter = new JPanel();
	
	public PieChartFrameME() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PieChartFrame");
		setSize(700, 500);
		
		setNorth();
		setCenter();
		
		
		setVisible(true);
		
	}
	
	private void setCenter() {
		con.add(pnlCenter,BorderLayout.CENTER);
		
		
		
	}

	private void setNorth() {
		con.add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.setBackground(Color.LIGHT_GRAY);
		pnlNorth.add(lblApple);
		pnlNorth.add(tfApple);
		pnlNorth.add(lblCherry);
		pnlNorth.add(tfCherry);
		pnlNorth.add(lblStrawberry);
		pnlNorth.add(tfStrawberry);
		pnlNorth.add(lblPrune);
		pnlNorth.add(tfPrune);
		

		
		
	}

	public static void main(String[] args) {
		new PieChartFrameME();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
