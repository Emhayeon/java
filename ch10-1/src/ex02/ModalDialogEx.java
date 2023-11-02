package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ModalDialogEx extends JFrame {
	private Container con = getContentPane();
	private JButton btnClick = new JButton("Click");
	private MyDialog dialog = new MyDialog(this, "모달 다이얼로그", true);
	
	public ModalDialogEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("모달 다이얼로그 예제");
		setSize(500, 500);
		btnClick.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				System.out.println("다이얼로그 열림");
			}
		});
		con.add(btnClick);
		setVisible(true);
	}
	
	public class MyDialog extends JDialog {
		private JTextField tfName = new JTextField(10);
		private JButton btnOk = new JButton("OK");
		
		public MyDialog(JFrame frame, String title, boolean isModal) {
			super(frame, title, isModal);
			// 다이어로그의 기본 배치관리자 - 보더 레이아웃
			this.setLayout(new FlowLayout());
			setSize(200, 100);
			this.add(tfName);
			this.add(btnOk);
			btnOk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = tfName.getText();
					btnClick.setText(name);
					MyDialog.this.setVisible(false);
				}
			});
		}
	}

	public static void main(String[] args) {
		new ModalDialogEx();

	}

}