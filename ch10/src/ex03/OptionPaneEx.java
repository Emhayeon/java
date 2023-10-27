package ex03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OptionPaneEx extends JFrame {
	private Container con = getContentPane();
	private JButton btnInput = new JButton("Input Name");
	private JButton btnConfirm = new JButton("Confirm");
	private JButton btnMessage = new JButton("Message");
	private JTextField tfResult = new JTextField(10);
	
	public OptionPaneEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("옵션팬 예제");
		setSize(500, 200);
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.DARK_GRAY);
		pnlNorth.add(btnInput);
		pnlNorth.add(btnConfirm);
		pnlNorth.add(btnMessage);
		pnlNorth.add(tfResult);
		con.add(pnlNorth, BorderLayout.NORTH);
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 다이얼로그 - prompt()
				String name = JOptionPane.showInputDialog(
						OptionPaneEx.this, "이름을 입력하세요", 
						"입력", JOptionPane.INFORMATION_MESSAGE);
				// System.out.println(name);
				if (name != null && !name.equals("")) {
					tfResult.setText(name);
				}
			}
		});
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확정 다이얼로그 - confirm()
				int result = JOptionPane.showConfirmDialog(
						OptionPaneEx.this, "계속하겠습니까?", 
						"계속", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					tfResult.setText("창닫음");
				} else if (result == JOptionPane.NO_OPTION) {
					tfResult.setText("아니오");
				} else if (result == JOptionPane.YES_OPTION) {
					tfResult.setText("예");
				}
			}
		});
		
		btnMessage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메시지 알림 다이얼로그 - alert()
				JOptionPane.showMessageDialog(
						OptionPaneEx.this, "조심하세요", 
						"알림", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new OptionPaneEx();
	}

}