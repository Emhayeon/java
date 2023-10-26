package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OpenChallengeFramee extends JFrame {//쌤이한거

	private static final long serialVersionUID = 1L;
	Container con = getContentPane();
	
	public OpenChallengeFramee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Open Challenge 8");
		setSize(500, 500);
		setUI();
		setVisible(true);
	}

	private void setUI() {
		setNorth();
		setCenter();
		
	}

	private void setCenter() {
		con.add(new CenterPanel(), BorderLayout.CENTER);
		
	}

	private void setNorth() {
		con.add(new NorthPanel(), BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		new OpenChallengeFramee();

	}

}

@SuppressWarnings("serial")
class CenterPanel extends JPanel {

	public CenterPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		JLabel lblHello = new JLabel("Hello Java!");
		lblHello.setBounds(200, 200, 100, 30);
		add(lblHello);
	}
}

@SuppressWarnings("serial")
class NorthPanel extends JPanel {
	String[] texts = {"Open", "Read", "Close"};

	public NorthPanel() {
		setBackground(Color.GRAY);
		for (int i = 0; i < texts.length; i++) {
			add(new JButton(texts[i]));
		}
	}
}