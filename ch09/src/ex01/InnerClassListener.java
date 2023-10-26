package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InnerClassListener extends JFrame{
	private Container con = getContentPane();
	private JButton btnAction = new JButton("Action");
	private JButton btnJava = new JButton("Java");
	private YourActionListener lis = new YourActionListener();
	
	
	public InnerClassListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("내부 클래스로 리스너 만들기");
		setSize(500,500);
		con.setLayout(new FlowLayout());
		con.add(btnAction);
		con.add(btnJava);
		btnAction.addActionListener(lis);//버튼에 감시자를 붙임
		btnJava.addActionListener(lis);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new InnerClassListener();

	}
	//내부클래스 -멤버처럼 사용하고자 할 때
	//외부 클래스의 멤버(필드 , 메서드)에 바로 접근 가능
	class YourActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println("클릭했어요"); 클릭되는지 확인
			//Action <->액션
			/*
			Object obj = e.getSource();//obj다운캐스팅하기
			JButton theButton = (JButton)obj;//다운캐스팅
			*/
			
			Object obj = e.getSource(); // 액션이벤트가 발생한 객체
			JButton theButton = (JButton)obj;
			String text = theButton.getText();
			//외부클래스의 멤버(필드)에 바로 접근 가능
			if(obj == btnAction) {
				if(text.equals("Action")) {
					btnAction.setText("액션");
				} else if(text.equals("액션")){
					btnAction.setText("Action");
				}
			}else if (obj == btnJava) {
				if(text.equals("Java")) {
					btnJava.setText("자바");
				} else if(text.equals("자바")){
					btnJava.setText("Java");
				}
			}
			
			
			
			
			//외부클래스의 멤버(필드)인 btnAction애 바로 접근 가능
			/*
			String text = btnAction.getText(); //theButton->btnAction
			System.out.println(text);
			if(text.equals("Action")) {
				btnAction.setText("액션");
			} else {
				btnAction.setText("Action");
			}
			*/
			
		}
		
	}

}//class

