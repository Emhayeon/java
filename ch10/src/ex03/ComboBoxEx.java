package ex03;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ComboBoxEx extends JFrame {
	private Container con = getContentPane();
	private String[] fruits = {"사과", "바나나", "키위", "망고"};
	private JComboBox<String> combo = new JComboBox<>(fruits);
	private ImageIcon[] images = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/banana.jpg"),
			new ImageIcon("images/kiwi.jpg"),
			new ImageIcon("images/mango.jpg ")
	};
	private JLabel label = new JLabel(images[0]);
	
	public ComboBoxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("콤보박스 예제");
		setSize(300, 200);
		con.setLayout(new FlowLayout());
		con.add(combo);
		con.add(label);
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = combo.getSelectedIndex();
				// System.out.println("index:" + index);
				label.setIcon(images[index]);
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBoxEx();
	}

}