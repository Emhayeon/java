package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class IndepClassListener extends JFrame{
	private Container con = getContentPane();
	private JButton btnAction = new JButton("Action");
	private MyActionListener lis = new MyActionListener();
	
	
	public IndepClassListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("독립된 클래스로 리스너 만들기");
		setSize(500,500);
		con.setLayout(new FlowLayout());
		con.add(btnAction);
		btnAction.addActionListener(lis);//버튼에 감시자를 붙임
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IndepClassListener();

	}

}//class

class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("클릭했어요"); 클릭되는지 확인
		//Action <->액션
		Object obj = e.getSource();//obj다운캐스팅하기
		JButton theButton = (JButton)obj;//다운캐스팅
		String text = theButton.getText();
		System.out.println(text);
		if(text.equals("Action")) {
			theButton.setText("액션");
		} else {
			theButton.setText("Action");
		}
		
		
	}
	
}
