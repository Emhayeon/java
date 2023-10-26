package ver12Te;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame implements ActionListener {
	private static final String DELIM = " / ";
	private PhoneBook book = PhoneBook.getInstance();
	private Container con = getContentPane();
	// North
	JTextField tfName = new JTextField(); // 이름
	JTextField tfPhoneNumber = new JTextField(); // 전화번호
	JTextField tfBirdthDay = new JTextField(); // 생일
	JRadioButton rdoSchool = new JRadioButton("학교", true);
	JRadioButton rdoCompany = new JRadioButton("회사");
	JTextField tfSchoolOrCompanyName = new JTextField();
	
	// Center
	JTextArea taMessage = new JTextArea();
	
	// South
	JTextField tfSearch = new JTextField(10);
	JButton btnSearch = new JButton("찾기");
	JButton btnInput = new JButton("입력");
	JButton btnGetAll = new JButton("전체조회");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnExit = new JButton("종료");
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("전화번화부 ver.12");
		setSize(500, 500);
		setUI();
		setListener();
		setVisible(true);
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

	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(2, 1));
		JPanel pnlSearch = new JPanel();
		pnlSearch.add(new JLabel("검색:"));
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		pnlSouth.add(pnlSearch);
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

	private void setNorth() {
		JPanel pnlInput = new JPanel();
		pnlInput.setLayout(new GridLayout(2, 4));
		pnlInput.add(new JLabel("이름:"));
		pnlInput.add(tfName);
		pnlInput.add(new JLabel("전화번호:"));
		pnlInput.add(tfPhoneNumber);
		pnlInput.add(new JLabel("생일:"));
		pnlInput.add(tfBirdthDay);
		JPanel pnlSchoolOrCompany = new JPanel();
		pnlSchoolOrCompany.add(rdoSchool);
		pnlSchoolOrCompany.add(rdoCompany);
		ButtonGroup group = new ButtonGroup();
		group.add(rdoSchool);
		group.add(rdoCompany);
		pnlInput.add(pnlSchoolOrCompany);
		pnlInput.add(tfSchoolOrCompanyName);
		con.add(pnlInput, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		new PhoneBookFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfSearch || obj == btnSearch) {
			
		} else if (obj == btnInput) {
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
			book.addInfo(info);
		} else if (obj == btnGetAll) {
			Vector<PhoneInfo> vector = book.getAll();
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
		} else if (obj == btnUpdate) {
			
		} else if (obj == btnDelete) {
			
		} else if (obj == btnExit) {
			System.exit(0);
		}
		
	}
}