package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JLabelEx extends JFrame {
	private Container con = getContentPane();
	private JLabel label1 = new JLabel("안녕하세요");
	private JLabel label2 = new JLabel(new ImageIcon("images/cat.png"));
	private JLabel label3 = new JLabel("강아지", new ImageIcon("images/dog.png"), SwingConstants.CENTER);
	
	
	public JLabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("레이블 예제");
		setSize(400,600);
		
		con.setLayout(new FlowLayout());
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label2.setIcon(new ImageIcon("images/dog.png"));
			}
		});
		con.add(label1);
		con.add(label2);
		con.add(label3);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new JLabelEx();

	}

}
