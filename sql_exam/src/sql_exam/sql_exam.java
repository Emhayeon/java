package sql_exam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class sql_exam extends JFrame implements ActionListener{
	private Container con = getContentPane();
	private sql_examDao sqldao = sql_examDao.getInstance();
	private InputDialog dialog = new InputDialog(this,"학생관리",true);
	
	
	//North
	private JButton btnInput = new JButton("입력");
	private JButton btnUpdate = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnRefer  = new JButton("조회");
	private JPanel pnlNorth = new JPanel();
	
	//Center
	private TextArea tamessage = new TextArea();
	private JPanel pnlCenter = new JPanel();
	
	
	public sql_exam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생관리프로그램");
		setSize(500,300);
		con.add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.add(btnInput);
		pnlNorth.add(btnUpdate);
		pnlNorth.add(btnDelete);
		pnlNorth.add(btnRefer);
		con.add(pnlCenter,BorderLayout.CENTER);
		pnlCenter.add(tamessage);
		setListener();
		
		
		setVisible(true);
	}
	private void setListener() {
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnRefer.addActionListener(this);
	}
	public static void main(String[] args) {
		new sql_exam();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnInput) {
			dialog.setVisible(true);
		
		} else if(obj == btnDelete) {
			String name = JOptionPane.showInputDialog("이름을 입력하세요.");
			boolean result = sqldao.delete(name);
			if(result) {
				JOptionPane.showMessageDialog(this, "삭제 완료>.<");
			}else {
				JOptionPane.showMessageDialog(this, "삭제 실패T.T");
			}
		
		} else if(obj == btnRefer) {
			Vector<sql_examVo> vec =sqldao.getAll();
			if(vec == null || vec.size() == 0) {
				tamessage.setText("---데이터가 없습니다.---");
			} else {
				printData(vec);
				
			}
		
		} else if (obj == btnUpdate) {
		
			String studentid = JOptionPane.showInputDialog("수정할 학번을 입력하세요.");
			if(studentid != null) {
				
			}
			
			sql_examVo examVo = new sql_examVo();
			boolean result = sqldao.update(examVo);
			if(result) {
				JOptionPane.showMessageDialog(this, "수정완료");
			} else {
				JOptionPane.showMessageDialog(this, "수정실패");
			}
		}
	}
	private void Itemname() {
		tamessage.setText("");
		tamessage.append("학번");
		tamessage.append("|");
		tamessage.append("이름");
		tamessage.append("|");
		tamessage.append("점수");
		tamessage.append("|");
		tamessage.append("학년");
		tamessage.append("|");
		tamessage.append("전공");
		tamessage.append("|");
		tamessage.append("성별");
		tamessage.append("\n");
	}
	
	private void printData(Vector<sql_examVo> vec) {
		tamessage.setText("");
		Itemname();
		for(sql_examVo examVo : vec) {
			
			String stuid = examVo.getStudentid();
			String stuname = examVo.getName();
			int stuscore = examVo.getScore();
			 int stugrade = examVo.getGrade();
			int stumajor = examVo.getMajor();
			String gender = examVo.getGender();
			
			tamessage.append(stuid);
			tamessage.append(" | ");
			tamessage.append(stuname);
			tamessage.append(" | ");
			tamessage.append(String.valueOf(stuscore));
			tamessage.append(" | ");
			tamessage.append(String.valueOf(stugrade));
			tamessage.append(" | ");
			tamessage.append(String.valueOf(stumajor));
			tamessage.append(" | ");
			tamessage.append(gender);
			tamessage.append("\n");
			
		}
		
	}
	
	class InputDialog extends JDialog implements ActionListener{
		
		JLabel lblstdentid = new JLabel("학번");
		JTextField tfstdentid = new JTextField();
		JLabel lblname = new JLabel("이름");
		JTextField tfname = new JTextField();
		JLabel lblscore = new JLabel("점수");
		JTextField tfscore = new JTextField();
		JLabel lblgrade = new JLabel("학년");
		JComboBox<String> gradecombo = new JComboBox<String>(new String[] {
			"1학년", "2학년", "3학년", "4학년" });
		JLabel lblmajor = new JLabel("전공");
		JComboBox<String> Majorcombo = new JComboBox<String>(new String[] {
				"경영", "화학", "컴퓨터공학과", "피아노" });
		JLabel lblgender = new JLabel("성별");
		JPanel pnlgender = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton rdowomen = new JRadioButton("F",true);
		JRadioButton rdomen = new JRadioButton("M");
		JButton btnFinish = new JButton("입력완료");
		JButton btnCancel = new JButton("취소");
		
		public InputDialog(JFrame owner, String title, boolean isModal) {
			super(owner,title,isModal);
			setSize(300,300);
			setLayout(new GridLayout(7,2));
			//setVisible(true);
			setUI();
			btnFinish.addActionListener(this);
			btnCancel.addActionListener(this);
			
		}

		private void setUI() {
			add(lblstdentid);
			add(tfstdentid);
			add(lblname);
			add(tfname);
			add(lblgrade);
			add(gradecombo);
			add(lblgender);
			pnlgender.add(rdowomen);
			pnlgender.add(rdomen);
			group.add(rdowomen);
			group.add(rdomen);
			add(pnlgender);
			add(lblmajor);
			add(Majorcombo);
			add(lblscore);
			add(tfscore);
			add(btnFinish);
			add(btnCancel);
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnFinish) {
				String stuid = tfstdentid.getText();
				String stuname = tfname.getText();
				int stuscore = Integer.parseInt(tfscore.getText());
				 int stugrade = gradecombo.getSelectedIndex()+1;
				int stumajor = Majorcombo.getSelectedIndex()+1;
				String sturdo = "";
				if(rdowomen.isSelected()) {
					sturdo=rdowomen.getText();
				} else if(rdomen.isSelected()) {
					sturdo=rdomen.getText();
				}
				
				
				sql_examVo examVo = new sql_examVo(stuid, stuname, stugrade, sturdo, stumajor, stuscore);
				System.out.println("examVo"+examVo);
				boolean result = sqldao.addInput(examVo);
				if(result) {
					JOptionPane.showMessageDialog(null, "사용자 등록 완료","완료",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "사용자 등록 실패","실패",JOptionPane.ERROR_MESSAGE);

				}
				
				
			} else if(obj == btnCancel) {
				this.setVisible(false);
			}
			
		}
		
	}

}
