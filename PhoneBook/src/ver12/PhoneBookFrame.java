package ver12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame implements ActionListener{
	
	private Container con = getContentPane();
	//North
	private GridLayout layoutN = new GridLayout(2,4);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlJob = new JPanel();
	private JTextField tfName = new JTextField();
	private JTextField tfTel = new JTextField();
	private JTextField tfBirth = new JTextField();
	private JTextField tfJob = new JTextField();
	private JLabel lblName = new JLabel("이름:");
	private JLabel lblTel = new JLabel("전화번호:");
	private JLabel lblBirth = new JLabel("생일:");
	private JRadioButton rdoS = new JRadioButton("학교",true);
	private JRadioButton rdoC = new JRadioButton("회사");
	
	//Center
	private JTextArea taMessage = new JTextArea();
	
	//South
	private GridLayout layoutS = new GridLayout(2,1);
	private JPanel pnlSorth = new JPanel();
	private JPanel pnlSorth1 = new JPanel();
	private JPanel pnlSorth2 = new JPanel();
	private JLabel lblSearch = new JLabel("검색:");
	private JTextField tfSearch = new JTextField(10);
	private JButton btnFind = new JButton("찾기"); 
	private JButton btnInput = new JButton("입력"); 
	private JButton btnView = new JButton("전체조회"); 
	private JButton btnMod = new JButton("수정"); 
	private JButton btnDelete = new JButton("삭제"); 
	private JButton btnEnd = new JButton("종료"); 
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("전화번호부 ver.12");
		setSize(800,500);
		setUI();
		setListener();
		
		
		
		setVisible(true);
	}

	private void setListener() {
		
		tfSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnDelete.addActionListener(this);
		btnEnd.addActionListener(this);
		btnFind.addActionListener(this);
		btnMod.addActionListener(this);
		btnView.addActionListener(this);

		
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
		
	}
	private void setNorth() {
		con.add(pnlNorth,BorderLayout.NORTH);
		
		pnlNorth.add(lblName);
		pnlNorth.add(tfName);
		pnlNorth.add(lblTel);
		pnlNorth.add(tfTel);
		pnlNorth.add(lblBirth);
		pnlNorth.add(tfBirth);
		pnlNorth.add(pnlJob);
		pnlJob.add(rdoS);
		pnlJob.add(rdoC);
		pnlNorth.add(tfJob);
		pnlNorth.setLayout(layoutN);
		
		
		
	}
	private void setCenter() {
		con.add(new JScrollPane(taMessage),BorderLayout.CENTER);
		
	}
	private void setSouth() {
		pnlSorth.setLayout(layoutS);
		con.add(pnlSorth,BorderLayout.SOUTH);
		pnlSorth1.setBackground(Color.YELLOW);
		pnlSorth.add(pnlSorth1);
		pnlSorth1.add(lblSearch);
		pnlSorth1.add(tfSearch);
		pnlSorth1.add(btnFind);
		pnlSorth.add(pnlSorth2);
		pnlSorth2.setBackground(Color.ORANGE);
		pnlSorth2.add(btnInput);
		pnlSorth2.add(btnView);
		pnlSorth2.add(btnMod);
		pnlSorth2.add(btnDelete);
		pnlSorth2.add(btnEnd);
		
	}
	public static void main(String[] args) {
		new PhoneBookFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == tfSearch || obj == btnFind) {
			
		}else if(obj == btnInput){
			
		}
		}
		
			
			
			
		
	
}
