package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextFieldEx extends JFrame{
	private Container con = getContentPane();
	
	public TextFieldEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("텍스트 필드 예제");
		setSize(300,150);
		
		JLabel lblName = new JLabel("이름:");
		JLabel lblPart = new JLabel("학과:");
		JLabel lblAddr = new JLabel("주소:");
		
		JTextField tfName = new JTextField(20);
		JTextField tfPart = new JTextField("컴퓨터 공학과",20);
		JTextField tfAddr = new JTextField("울산광역시 남구",20);
		
		tfPart.setEditable(false);
		tfAddr.setEnabled(false);
		
		con.setLayout(new FlowLayout());
		con.add(lblName);
		con.add(tfName);
		con.add(lblPart);
		con.add(tfPart);
		con.add(lblAddr);
		con.add(tfAddr);
		
		tfName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("엔터");
				
				String temp= lblPart.getText();//스와핑 엔터치면 위아래 바뀌게함
				lblPart.setText(lblAddr.getText());
				lblAddr.setText(temp);
				
				String temp2 = tfPart.getText();
				tfPart.setText(tfAddr.getText());
				tfAddr.setText(temp2);
			}
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new TextFieldEx();

	}

}
