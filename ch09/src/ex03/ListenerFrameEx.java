package ex03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ListenerFrameEx extends JFrame
	implements ActionListener{

	private Container con = getContentPane();
	private JButton button = new JButton("Click");
	
	public ListenerFrameEx() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("프레임 리스너 예제");
	setSize(500,500);
	setVisible(true);
	//컨테이너에 버튼달기
	con.add(button);
	//버튼에 액션 리스너 달기
	button.addActionListener(this); //액션리스너=ListenerFrameEx
	
	}
	public static void main(String[] args) {
		new ListenerFrameEx();
	}
	@Override //프레임이 구현
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭");
	}

}
