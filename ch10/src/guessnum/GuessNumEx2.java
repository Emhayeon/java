package guessnum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessNumEx2 extends JFrame implements ActionListener{
	private Container con = getContentPane();
	private JButton btnInput = new JButton("입력");
	private JButton btnReset = new JButton("새게임");
	private JPanel pnlInput = new JPanel();
	private JPanel pnlNum = new JPanel();
	private JTextArea taNum = new JTextArea("1~100사이의 임의의 숫자를 맞춰보세요.\n",10,30);
	private JLabel lblNum = new JLabel("남은횟수:");
	private JTextField tfInput = new JTextField(3);
	private JTextField tfNum = new JTextField("♥♥♥♥♥",4);
	private JLabel lblRecord = new JLabel("기록:");
	private JTextField tfRecord = new JTextField("30000",4);

	
	public GuessNumEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자 맞추기");
		setSize(500,500);
		setUI();
		
		con.add(new JScrollPane(taNum));
		taNum.setFont(new Font("맑은 고딕",Font.BOLD, 15));
		tfRecord.setEditable(false);
		taNum.setEditable(false);
		tfNum.setEditable(false);
		
		tfInput.addActionListener(this);
		btnInput.addActionListener(this);
		btnReset.addActionListener(this);
		
		setVisible(true);
	}
	private void setUI() {
		con.add(pnlInput, BorderLayout.NORTH);
		pnlInput.setBackground(Color.YELLOW);
		pnlInput.add(tfInput);
		pnlInput.add(btnInput);
		pnlInput.add(lblRecord);
		pnlInput.add(tfRecord);
		pnlInput.add(btnReset);
		
		
	
		con.add(pnlNum, BorderLayout.SOUTH);
		pnlNum.setBackground(Color.CYAN);
		pnlNum.add(lblNum);
		pnlNum.add(tfNum);
		
		con.add(taNum, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new GuessNumEx2();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
