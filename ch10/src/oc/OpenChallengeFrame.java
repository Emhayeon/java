package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenChallengeFrame extends JFrame {
	private Container con = getContentPane();
	private JLabel lblImage = new JLabel(new ImageIcon("images/image0.jpg"));
	private MenuPanel pnlMenu = new MenuPanel();
	// private ImageIcon[] images = new ImageIcon[4];
	private Vector<ImageIcon> images = new Vector<>();
	private int index = 0;
	public OpenChallengeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("간단 이미지 뷰어");
		setSize(500, 500);
		setImages();
		setUI();
		setVisible(true);
	}
	
	private void setUI() {
		con.add(lblImage, BorderLayout.CENTER);
		con.add(pnlMenu, BorderLayout.SOUTH);
	}

	private void setImages() {
		for (int i = 0; i < images.size(); i++) {
			//images[i] = new ImageIcon("images/image" + i + ".jpg");
			images.add(new ImageIcon("images/image" + i + ".jpg"));
		}
		
	}

	public class MenuPanel extends JPanel implements ActionListener {
		private JButton btnLeft = new JButton(new ImageIcon("images/left.png"));
		private JButton btnRight = new JButton(new ImageIcon("images/right.png"));
		
		public MenuPanel() {
			add(btnLeft);
			add(btnRight);
			setBackground(Color.DARK_GRAY);
			btnLeft.addActionListener(this);
			btnRight.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btnLeft) {
				// System.out.println("Left");
				index--;
				if (index < 0) {
					index = images.size() - 1; //3;
				}
			} else if (obj == btnRight) {
				// System.out.println("Right");
				index++;
				if (index > images.size() - 1) {
					index = 0;
				}
			}
			lblImage.setIcon(images.get(index));
			
		}
	}

	public static void main(String[] args) {
		new OpenChallengeFrame();

	}

}