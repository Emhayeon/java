package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenChallengdFrame extends JFrame {
	
	Container con = getContentPane();
	JPanel pn1 = new JPanel();
	
	
	public OpenChallengdFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("OpenChallengdFrame");
		this.setSize(500,500);
		
		con.setLayout(new BorderLayout());
		con.add(new NorthPabel(),BorderLayout.NORTH);
		con.add(new CenterPabel(),BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		new OpenChallengdFrame();

	}

}
@SuppressWarnings("serial")
class NorthPabel extends JPanel{
	
	public NorthPabel() {
		this.setBackground(Color.GRAY);
		this.add(new JButton("Open"));
		this.add(new JButton("Read"));
		this.add(new JButton("Close"));
	}
}
@SuppressWarnings("serial")
class CenterPabel extends JPanel{
	
	public CenterPabel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		JLabel lblHello = new JLabel("Hello Java!");
		lblHello.setBounds(200, 200, 100, 30);
		add(lblHello);
	}
}

