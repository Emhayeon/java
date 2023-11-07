package ver15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame implements ActionListener {
	private static final String DELIM = " | ";
	private PhoneBook book = PhoneBook.getInstance();
	private Container con = getContentPane();
	private JFileChooser chooser = new JFileChooser("./");
	private FileNameExtensionFilter filter =
			new FileNameExtensionFilter("데이터 파일(txt)", "txt");
	
	// Center
	private JTextArea taMessage = new JTextArea();
	
	// South
	private JTextField tfSearch = new JTextField(10);
	private JButton btnSearch = new JButton("찾기");
	private JButton btnInput = new JButton("입력");
	private JButton btnGetAll = new JButton("전체조회");
	private JButton btnUpdate = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnExit = new JButton("종료");
	
	JMenuItem miLoad = new JMenuItem("불러오기");
	JMenuItem miSave = new JMenuItem("저장하기");
	JMenuItem miInput = new JMenuItem("입력");
	JMenuItem miGetAll = new JMenuItem("전체조회");
	JMenuItem miUpdate = new JMenuItem("수정");
	JMenuItem miDelete = new JMenuItem("삭제");
	JMenuItem miExit = new JMenuItem("종료");
	
	private MyInputDialog myInputDialog = new MyInputDialog(this, "입력", true);
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("전화번화부 ver.14");
		setSize(500, 500);
		setUI();
		setMenu();
		setListener();
		setVisible(true);
	}

	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnuFile = new JMenu("파일");
		
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miInput);
		mnuFile.add(miGetAll);
		mnuFile.add(miUpdate);
		mnuFile.add(miDelete);
		mnuFile.addSeparator();
		mnuFile.add(miExit);
		
		menuBar.add(mnuFile);
		setJMenuBar(menuBar);
	}

	private void setListener() {
		tfSearch.addActionListener(this);
		btnSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnGetAll.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		
		miLoad.addActionListener(this);
		miSave.addActionListener(this);
		miInput.addActionListener(this);
		miGetAll.addActionListener(this);
		miUpdate.addActionListener(this);
		miDelete.addActionListener(this);
		miExit.addActionListener(this);
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
		chooser.setFileFilter(filter);
	}

	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnInput);
		pnlSouth.add(btnGetAll);
		pnlSouth.add(btnUpdate);
		pnlSouth.add(btnDelete);
		pnlSouth.add(btnExit);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setCenter() {
		taMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		
	}

	private void setNorth() {
		JPanel pnlSearch = new JPanel();
		pnlSearch.add(new JLabel("검색:"));
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		con.add(pnlSearch, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		new PhoneBookFrame();
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		System.out.println(obj);
		
		if (obj == tfSearch || obj == btnSearch) {
			String name = tfSearch.getText();
			if (name != null && !name.equals("")) {
				PhoneInfo info = book.searchByName(name);
				if (info == null) {
					taMessage.append("\n" + name + "님의 정보가 없습니다.");
				} else {
					printData(info);
					taMessage.append("\n---- 검색 완료 ----");
				}
			}
		} else if (obj == miLoad) {
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				String path = chooser.getSelectedFile().getPath();
				book.load(path);
			}
		} else if (obj == miSave) { 
			int result = chooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				String path = chooser.getSelectedFile().getPath();
				book.save(path);
			}
		} else if (obj == btnInput || obj == miInput) {
			myInputDialog.setVisible(true);
		
		} else if (obj == btnGetAll || obj == miGetAll) {
			Vector<PhoneInfo> vector = book.getAll();
			if (vector == null || vector.size() == 0) {
				taMessage.setText("---- 데이터가 없습니다. ----");
			} else {
				printData(vector);
			}
		} else if (obj == btnUpdate || obj == miUpdate) {
			String name = JOptionPane.showInputDialog(PhoneBookFrame.this, 
					"이름을 입력하세요", "입력", 
					JOptionPane.OK_CANCEL_OPTION);
			if (name != null && !name.equals("")) {
				myInputDialog.setInputOrUpdate("수정");
				PhoneInfo info = book.searchByName(name);
				if (info == null) {
					JOptionPane.showMessageDialog(null, "데이터 수정에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				myInputDialog.setInfo(info);
				myInputDialog.setVisible(true);
			}
		} else if (obj == btnDelete || obj == miDelete) {
			String name = JOptionPane.showInputDialog(null, "이름을 입력하세요");
			boolean result = book.delete(name);
			if (result) {
				taMessage.append("\n" + name + "의 정보를 삭제했습니다.");
			} else {
				taMessage.append("\n" + name + "의 정보가 없습니다.");
			}
		} else if (obj == btnExit || obj == miExit) {
			System.exit(0);
		} 
		
	}
	
	class MyInputDialog extends JDialog implements ActionListener {
		private JTextField tfName = new JTextField(); // 이름
		private JTextField tfPhoneNumber = new JTextField(); // 전화번호
		private JTextField tfBirdthDay = new JTextField(); // 생일
		private JRadioButton rdoSchool = new JRadioButton("학교", true);
		private JRadioButton rdoCompany = new JRadioButton("회사");
		private JTextField tfSchoolOrCompanyName = new JTextField();
		private JButton btnFinish = new JButton("입력완료");
		private JButton btnCancel = new JButton("취소");
		
		public MyInputDialog(JFrame owner, String title, boolean modal) {
			super(owner, title, modal);
			this.setSize(300, 200);
			this.setLayout(new GridLayout(5, 2, 10, 10));
			this.add(new JLabel("이름:"));
			this.add(this.tfName);
			this.add(new JLabel("전번:"));
			this.add(this.tfPhoneNumber);
			this.add(new JLabel("생일"));
			this.add(this.tfBirdthDay);
			JPanel panel = new JPanel();
			ButtonGroup group = new ButtonGroup();
			panel.add(this.rdoSchool);
			panel.add(this.rdoCompany);
			group.add(rdoSchool);
			group.add(rdoCompany);
			this.add(panel);
			this.add(this.tfSchoolOrCompanyName);
			this.add(this.btnFinish);
			this.add(this.btnCancel);
			this.btnFinish.addActionListener(this);
			this.btnCancel.addActionListener(this);
		}
		
		public void setInputOrUpdate(String title) {
			setTitle(title);
			if (title.equals("입력")) {
				tfName.setEditable(true);
			} else if (title.equals("수정")) {
				tfName.setEditable(false);
			}
			btnFinish.setText(title + "완료");
		}
		
		public void setInfo(PhoneInfo info) {
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
			String name = this.tfName.getText();
			String phoneNumber = this.tfPhoneNumber.getText();
			String birthDay = this.tfBirdthDay.getText();
			String schoolOrCompanyName = this.tfSchoolOrCompanyName.getText();
			PhoneInfo info = null;
			if (this.rdoSchool.isSelected()) {
				info = new PhoneInfoSchool(name, phoneNumber, birthDay, schoolOrCompanyName);
			} else {
				info = new PhoneInfoCompany(name, phoneNumber, birthDay, schoolOrCompanyName);
			}
			return info;
		}
		
		private void showMessage(String message) {
			JOptionPane.showMessageDialog(PhoneBookFrame.this, message, "알림", JOptionPane.INFORMATION_MESSAGE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String title = getTitle();
			
			if (obj == btnFinish) {
				boolean result = false;
				if (title.equals("입력")) {
					PhoneInfo info = this.makePhoneInfo();
					System.out.println(info);
					result = book.addInfo(info);
					
				} else if (title.equals("수정")) {
					PhoneInfo info = this.makePhoneInfo();
					System.out.println(info);
					result = book.modify(info);
				}
				
				if (result) {
					showMessage("데이터 " + title + " 완료");
				} else {
					showMessage("데이터 " + title + " 실패");
				}
				
			} else if (obj == btnCancel) {
				 this.setVisible(false);
			}
			this.setVisible(false);
		}
	}
}