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
public class PhoneBookFrame2 extends JFrame implements ActionListener {
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
	
	public PhoneBookFrame2() {
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
	}
	
	private boolean inputData(PhoneInfo info) {
		
		return book.addInfo(info);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfSearch || obj == btnSearch) {
			String name = tfName.getText();
			PhoneInfo info = book.searchByName(name);
			if (info == null) {
				taMessage.append("\n" + name + "님의 정보가 없습니다.");
			} else {
				printData(info);
				taMessage.append("\n---- 검색 완료 ----");
			}
		} else if (obj == btnInput) {
			PhoneInfo info = makePhoneInfo();
			boolean result = inputData(info);
			if (result == true) {
				taMessage.append("\n" + info.getName() + "님의 정보가 입력되었습니다.");
			} else {
				taMessage.append("\n" + info.getName() + "님의 정보 입력에 실패했습니다.");
			}
		} else if (obj == btnGetAll) {
			Vector<PhoneInfo> vector = book.getAll();
			if (vector == null || vector.size() == 0) {
				taMessage.setText("---- 데이터가 없습니다. ----");
			} else {
				printData(vector);
			}
		} else if (obj == btnUpdate) {
			PhoneInfo info = makePhoneInfo();
			boolean result = book.modify(info);
			if (result) {
				taMessage.append("\n" + info.getName() + "의 정보가 수정되었습니다.");
			} else {
				taMessage.append("\n" + info.getName() + "의 정보가 없습니다.");
			}
		} else if (obj == btnDelete) {
			String name = tfName.getText();
			boolean result = book.delete(name);
			if (result) {
				taMessage.append("\n" + name + "의 정보를 삭제했습니다.");
			} else {
				taMessage.append("\n" + name + "의 정보가 없습니다.");
			}
		} else if (obj == btnExit) {
			System.exit(0);
		}
		
	}
}