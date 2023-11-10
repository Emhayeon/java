package guessnum2;




import java.awt.Container;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener{
	

	private Container con = getContentPane();
	private JLabel lblId = new JLabel("아이디");
	private JTextField tfId = new JTextField();
	private JLabel lblPw = new JLabel("패스워드");
	private JPasswordField pfPw = new JPasswordField();
	private JButton btnLogin = new JButton("로그인");
	private JButton btnRegister = new JButton("사용자등록");
	private MyRegisterDialog dialog = new MyRegisterDialog(this,"사용자등록",true);
	
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		setSize(300,150);
		setUI();
		
		setVisible(true);
	}
	
	private void setUI() {
		
		con.setLayout(new GridLayout(3,2));
		con.add(lblId);
		con.add(tfId);
		con.add(lblPw);
		con.add(pfPw);
		con.add(btnLogin);
		con.add(btnRegister);
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnRegister) {
			dialog.setVisible(true);
		} 
			
	
	}
	public class MyRegisterDialog extends JDialog implements ActionListener{
		private JLabel lblId = new JLabel("아이디");
		private JTextField tfId = new JTextField();
		private JLabel lblPw = new JLabel("패스워드");
		private JPasswordField pfPw = new JPasswordField();
		private JLabel lblPpw = new JLabel("패스워드확인");
		private JPasswordField pfPpw = new JPasswordField();
		private JLabel lblName = new JLabel("이름");
		private JTextField tfName = new JTextField();
		private JLabel lblEmail = new JLabel("이메일");
		private JTextField tfEmail = new JTextField();
		private JButton btnOK = new JButton("완료");
		private JButton btnCancel = new JButton("취소");
		
		public MyRegisterDialog(JFrame owner, String title, boolean isModal) {
			super(owner,title,isModal);
			setSize(400,300);
			setLayout(new GridLayout(6, 2));
			this.setUI();
			
		}
		
		private void setUI() {
			add(lblId);
			add(tfId);
			add(lblPw);
			add(pfPw);
			add(lblPpw);
			add(pfPpw);
			add(lblName);
			add(tfName);
			add(lblEmail);
			add(tfEmail);
			add(btnOK);
			add(btnCancel);
			this.btnOK.addActionListener(this);
			this.btnCancel.addActionListener(this);
			
		}
		
		public void setInput(String title) {
			setTitle(title);
			btnOK.setText(title+"완료");
		}
		public void setVo(UserVo vo) {
			String id= vo.getId();
			String pw = vo.getPw();
			String name = vo.getName();
			String email = vo.getEmail();
			tfId.setText(id);
			pfPw.setText(pw);
			tfName.setText(name);
			tfEmail.setText(email);
		}
		private UserVo makeUserVo() {
			String id = tfId.getText();
			
			
			return null;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnOK) {
				
			}else if(obj == btnCancel) {
				setVisible(false);
			}
			
		}
		
	}
}
