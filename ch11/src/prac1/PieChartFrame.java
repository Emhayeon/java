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
public class PieChartFrame extends JFrame implements ActionListener{
	private Container con = getContentPane();
	private String[] fruits = {"apple","cherry","strawberry","prune"};
	private JTextField[] tfFruits = new JTextField[fruits.length];
	private int[] saleCounts = new int [fruits.length];
	private int[] percents = new int [fruits.length];
	private int[] angles = new int [fruits.length];
	
	public PieChartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PieChartFrame");
		setSize(700, 500);
		
	
		setNorth();
		setVisible(true);
		
	}
	
	

	private void setNorth() {
		
		
	}



	public static void main(String[] args) {
		new PieChartFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
