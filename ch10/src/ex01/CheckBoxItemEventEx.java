package ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CheckBoxItemEventEx extends JFrame implements ItemListener{
	private String[] names = {"사과", "배", "체리"};
	private int[] prices = {100, 500, 20000};
	private Container con = getContentPane();
	private JPanel pnlMenu = new JPanel();
	private JPanel pnlResult = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JLabel lblMenu = new JLabel();
	private JLabel lblResult = new JLabel("현재 0원 입니다.");
	private JCheckBox[] boxes = new JCheckBox[names.length];

	
	public CheckBoxItemEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("아이템 이벤트 예제");
		setSize(500, 300);
		String menuText = makeMenuText();
		lblMenu.setText(menuText);
		makeCheckBoxes();
		setUI();
		setListener();
		setVisible(true);
		
	}

	private void setListener() {
		for (int i = 0; i < boxes.length; i++) {
			boxes[i].addItemListener(this);
		}
		
	}

	private void makeCheckBoxes() {
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new JCheckBox(names[i]);
		}
		
	}

	private String makeMenuText() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < names.length; i++) {
			sb.append(names[i] + " " + prices[i] + "원");
			if (i != names.length-1) {
				sb.append(", ");
			}
		}
		String text = sb.toString();
		return text;
	}

	private void setUI() {
		// NORTH
		pnlMenu.setBackground(Color.GREEN);
		pnlMenu.add(lblMenu);
		con.add(pnlMenu, BorderLayout.NORTH);
		
		// CENTER
		for (int i = 0; i < boxes.length; i++) {
			pnlCenter.add(boxes[i]);
		}

		con.add(pnlCenter, BorderLayout.CENTER);
		
		// SOUTH
		pnlResult.setBackground(Color.PINK);
		pnlResult.add(lblResult);
		con.add(pnlResult, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int sum = 0;
		for(int i = 0; i < boxes.length; i++) {
			if(boxes[i].isSelected()) {
				sum += prices[i];
			}
		}
//		System.out.println("sum: "+sum);
		lblResult.setText("현재" + sum + "원 입니다.");
	}

}
