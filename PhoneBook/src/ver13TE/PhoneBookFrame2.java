package ver13TE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




@SuppressWarnings("serial")
public class PhoneBookFrame2 extends JFrame implements ActionListener {
	private static final String DELIM = " / ";
	private PhoneBook book = PhoneBook.getInstance();
	private Container con = getContentPane();
	private Vector<JMenuItem> vecItem = new Vector<>();
	private MyDialog dialog = new MyDialog(this, "입력", true);
	
	//North
	JTextField tfSearch = new JTextField(10);
//	JTextField tfName = new JTextField(); // 이름
//	JTextField tfPhoneNumber = new JTextField(); // 전화번호
//	JTextField tfBirdthDay = new JTextField(); // 생일
//	JRadioButton rdoSchool = new JRadioButton("학교", true);
//	JRadioButton rdoCompany = new JRadioButton("회사");
//	JTextField tfSchoolOrCompanyName = new JTextField();
	
	
	// Center
	JTextArea taMessage = new JTextArea();
	
	// South
	JButton btnSearch = new JButton("찾기");
	JButton btnInput = new JButton("입력");
	JButton btnGetAll = new JButton("전체조회");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnExit = new JButton("종료");
	
	public PhoneBookFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("전화번화부 ver.13");
		setSize(500, 500);
		setUI();
		setListener();
		setMeunbar();
		setVecListener();
	
		setVisible(true);
	}
	private void setVecListener() {
//		System.out.println("실행");
//		System.out.println(vecItem.size());
		for(int i=0; i<vecItem.size(); i++) {
			JMenuItem item = vecItem.get(i);
//			System.out.println(item.getActionCommand());
			item.addActionListener(this);
		}
		
	}
	private void setMeunbar() {
		// North
		
		JMenuBar meunBar = new JMenuBar();
		JMenu meunFile = new JMenu("파일");
		meunBar.add(meunFile);
		JMenuItem miInput = new JMenuItem("입력");
		JMenuItem miAll = new JMenuItem("전체조회");
		JMenuItem miModify = new JMenuItem("수정");
		JMenuItem miDelete = new JMenuItem("삭제");
		JMenuItem miExit = new JMenuItem("종료");
		vecItem.add(miInput);
		vecItem.add(miAll);
		vecItem.add(miModify);
		vecItem.add(miDelete);
		vecItem.add(miExit);
		meunFile.add(miInput);
		meunFile.add(miAll);
		meunFile.add(miModify);
		meunFile.add(miDelete);
		meunFile.addSeparator();
		meunFile.add(miExit);
		setJMenuBar(meunBar);
		meunBar.setBackground(Color.LIGHT_GRAY);
		
		
		
		
	}

	private void setListener() {
		tfSearch.addActionListener(this);
		btnSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnGetAll.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}

	private void setNorth() {
		JPanel pnlNorth = new JPanel();
		JPanel pnlSearch = new JPanel();
		pnlSearch.add(new JLabel("검색:"));
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		pnlNorth.add(pnlSearch);
		con.add(pnlNorth,BorderLayout.NORTH);
		
		JPanel pnlInput = new JPanel();
		pnlInput.setLayout(new GridLayout(2,4));
		pnlInput.add(new JLabel("이름:"));
//		pnlInput.add(tfName);
		pnlInput.add(new JLabel("전화번호:"));
//		pnlInput.add(tfPhoneNumber);
		pnlInput.add(new JLabel("생일:"));
//		pnlInput.add(tfBirdthDay);
		JPanel pnlSchoolOrCompany = new JPanel();
//		pnlSchoolOrCompany.add(rdoSchool);
//		pnlSchoolOrCompany.add(rdoCompany);
		ButtonGroup group = new ButtonGroup();
//		group.add(rdoSchool);
//		group.add(rdoCompany);
		pnlInput.add(pnlSchoolOrCompany);
//		pnlInput.add(tfSchoolOrCompanyName);
		
		
		
	}

	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(2, 1));
		JPanel pnlButton = new JPanel();
		pnlButton.add(btnInput);
		pnlButton.add(btnGetAll);
		pnlButton.add(btnUpdate);
		pnlButton.add(btnDelete);
		pnlButton.add(btnExit);
		pnlSouth.add(pnlButton);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setCenter() {
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);

		
	}

	

	public static void main(String[] args) {
		new PhoneBookFrame2();
	}
	
	private void printData(PhoneInfo info) {
		taMessage.setText("");
		
		String name = info.getName();
		String phoneNumber = info.getPhoneNumber();
		String birthDay = info.getBirthDay();
		String schoolOrCompanyName = "";
		if (info instanceof PhoneInfoSchool) {
			schoolOrCompanyName = ((PhoneInfoSchool)info).getSchool();
		} else {
			schoolOrCompanyName = ((PhoneInfoCompany)info).getCompany();
		}
		taMessage.append(name + DELIM);
		taMessage.append(phoneNumber + DELIM);
		taMessage.append(birthDay + DELIM);
		taMessage.append(schoolOrCompanyName + "\n");
		
	}
	
	private void printData(Vector<PhoneInfo> vector) {
		taMessage.setText("");
		for (PhoneInfo info : vector) {
			String name = info.getName();
			String phoneNumber = info.getPhoneNumber();
			String birthDay = info.getBirthDay();
			String schoolOrCompanyName = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompanyName = ((PhoneInfoSchool)info).getSchool();
			} else {
				schoolOrCompanyName = ((PhoneInfoCompany)info).getCompany();
			}
			taMessage.append(name + DELIM);
			taMessage.append(phoneNumber + DELIM);
			taMessage.append(birthDay + DELIM);
			taMessage.append(schoolOrCompanyName + "\n");
		}
	}
	
	
	private boolean inputData(PhoneInfo info) {
		
		return book.addInfo(info);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JMenuItem item = (JMenuItem)obj;
		
		String command = item.getActionCommand();
		switch (command) {
		case "입력":
			dialog.setVisible(true);
			
			break;
		case "전체조회":
			
			break;
		case "수정":
			
			break;
		case "삭제":
			
			break;
		case "종료":
			System.exit(0);
			break;
		}
		
		if (obj == tfSearch || obj == btnSearch) {
//			String name = tfName.getText();
//			PhoneInfo info = book.searchByName(name);
//			if (info == null) {
//				taMessage.append("\n" + name + "님의 정보가 없습니다.");
//			} else {
//				printData(info);
//				taMessage.append("\n---- 검색 완료 ----");
//			}
		} else if (obj == btnInput) {
			dialog.setVisible(true);

		
		} else if (obj == btnGetAll) {
			Vector<PhoneInfo> vector = book.getAll();
			if (vector == null || vector.size() == 0) {
				taMessage.setText("---- 데이터가 없습니다. ----");
			} else {
				printData(vector);
			}
		} else if (obj == btnUpdate) {
			
		
//			PhoneInfo info = makePhoneInfo();
//			boolean result = book.modify(info);
//			if (result) {
//				taMessage.append("\n" + info.getName() + "의 정보가 수정되었습니다.");
//			} else {
//				taMessage.append("\n" + info.getName() + "의 정보가 없습니다.");
//			}
		} else if (obj == btnDelete) {
		
//			String name = tfName.getText();
//			boolean result = book.delete(name);
//			if (result) {
//				taMessage.append("\n" + name + "의 정보를 삭제했습니다.");
//			} else {
//				taMessage.append("\n" + name + "의 정보가 없습니다.");
//			}
		} else if (obj == btnExit) {
			
			System.exit(0);
		}
		
			
		
		
		
	}
	public class MyDialog extends JDialog implements ActionListener{
		private JTextField tfName = new JTextField();
		private JTextField tfPhoneNumber = new JTextField(); 
		private JTextField tfBirdthDay = new JTextField();
		private JRadioButton rdoSchool = new JRadioButton("학교", true);
		private JRadioButton rdoCompany = new JRadioButton("회사");
		private JTextField tfSchoolOrCompanyName = new JTextField();
		private JButton btnInputOk = new JButton("입력완료");
		private JButton btnCancel = new JButton("취소");
		
		public MyDialog (JFrame owner, String title, boolean modal) {
			
			setTitle("입력");
			setSize(300,200);
			this.setLayout(new GridLayout(5,2,10,10));
			this.add(new JLabel("이름:"));
			this.add(tfName);
			this.add(new JLabel("전번:"));
			this.add(tfPhoneNumber);
			this.add(new JLabel("생일"));
			this.add(tfBirdthDay);
			JPanel panel = new JPanel();
			ButtonGroup group = new ButtonGroup();
			panel.add(this.rdoCompany);
			panel.add(this.rdoSchool);
			group.add(rdoSchool);
			group.add(rdoCompany);
			this.add(panel);
			this.add(this.tfSchoolOrCompanyName);
			this.add(this.btnInputOk);
			this.add(this.btnCancel);
			btnInputOk.addActionListener(this);
			btnCancel.addActionListener(this);
			
		}
		public void setInputOrUpdate(String title) {
			setTitle(title);
			btnInputOk.setText(title + "완료");
		}
		public void setInfo (PhoneInfo info) {
			String name = info.getName();
			String phoneNumber = info.getPhoneNumber();
			String birthDay = info.getBirthDay();
			String schoolOrCompany = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompany = ((PhoneInfoSchool)info).getSchool();
				rdoSchool.setSelected(true);
			} else if (info instanceof PhoneInfoCompany) {
				schoolOrCompany = ((PhoneInfoCompany)info).getCompany();
				rdoCompany.setSelected(true);
			}
			tfName.setText(name);
			tfPhoneNumber.setText(phoneNumber);
			tfBirdthDay.setText(birthDay);
			tfSchoolOrCompanyName.setText(schoolOrCompany);
		}
		private PhoneInfo makePhoneInfo() {
		String name = tfName.getText();
		String phoneNumber = tfPhoneNumber.getText();
		String birthDay = tfBirdthDay.getText();
		String schoolOrCompanyName = tfSchoolOrCompanyName.getText();
		PhoneInfo info = null;
		if (rdoSchool.isSelected()) {
			info = new PhoneInfoSchool(name, phoneNumber, birthDay, schoolOrCompanyName);
		} else {
			info = new PhoneInfoCompany(name, phoneNumber, birthDay, schoolOrCompanyName);
		}
		return info;
//			return null;
		}
		public void showMessage(String message) {
			JOptionPane.showMessageDialog(PhoneBookFrame2.this, message, "알림", JOptionPane.INFORMATION_MESSAGE);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnInputOk) {
					PhoneInfo info = this.makePhoneInfo();
					boolean result = book.addInfo(info);
					if(result) {
						showMessage("데이터 입력 완료");
					}else {
						showMessage("데이터 입력 실패");
					}
				
			}else if (obj == btnCancel) {
				
			}
			this.setVisible(false);
		}
	}
}
