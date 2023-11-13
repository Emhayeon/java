package guessnum2;




import java.awt.Container;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener{
	
	private UserDao userDao = UserDao.getInstance(); //싱글톤 다오 얻기
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
		//사용자 등록 버튼
		if(obj == btnRegister) {
			dialog.setVisible(true);
		} 
		//로그인 버튼 -다시해
		else if(obj == btnLogin) {
			String userId = tfId.getText();
			String suerPw = new String (pfPw.getPassword());
			LoginDto loginDto = new LoginDto(userId, suerPw);
			UserVo userVo = userDao.login(loginDto);
			
			//로그인 실패 -다시해
			if (userVo == null) {
				JOptionPane.showMessageDialog(null, "로그인 실패", "알림", JOptionPane.ERROR_MESSAGE);
			} 
			// 로그인 성공 -다시해
			else {
				JOptionPane.showMessageDialog(null, "로그인 성공", "알림", JOptionPane.INFORMATION_MESSAGE);
				new GuessNumFrame(userVo);
				this.dispose(); // 창 아예 없애기
			}
		
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
			setSize(300,200);
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
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnOK) {
				String userid = tfId.getText();
				char[] chars = pfPw.getPassword();//다시보기
				String userPw = new String(chars);
				String userName = tfName.getText();
				String userEmail = tfEmail.getText();
				
				//setters 이용
//				UserVo userVo = new UserVo();
//				userVo.setUserId(userid);
//				userVo.setUserPw(userPw);
//				userVo.setUserName(userName);
//				userVo.setUserEmail(userEmail);
				
				UserVo userVo = new UserVo(userid, userPw, userName, userEmail);//간단하게 이렇게하면됨
//				System.out.println("userId:"+userVo.getUserId());
//				System.out.println("userPw:"+userVo.getUserPw());
//				System.out.println("userName:"+userVo.getUserName());
//				System.out.println("userEmail:"+userVo.getUserEmail());
				System.out.println("userVo: "+ userVo.toString());
				System.out.println("userVo:"+userVo); //toString 생략해도 같은값나옴
				
				boolean result = userDao.addUser(userVo); //userdao에서 결과를 받아온거 다시보기(소영씨)
				//System.out.println("add result: "+ result);//잘얻어왔는지 확인 작업
				if(result ) {//showMessageDialog쓰기
					JOptionPane.showMessageDialog(null, "사용자 등록 완료","완료",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "사용자 등록 실패","실패",JOptionPane.ERROR_MESSAGE);
				}
				
				
			} else if (obj == btnCancel) {
				this.setVisible(false);
			}
			
		}
		
	}
}
