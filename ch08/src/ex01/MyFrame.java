package ex01;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings( "serial" )
public class MyFrame extends JFrame{
	Container c = getContentPane();
	private JButton button1 = new JButton("클릭");
// private static final long serialVersionUID = 1L; OR @SuppressWarnings( "serial" )둘 중 하나 써	
	
	public MyFrame() {
		
		//창닫기 버튼 클릭시 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//창의 제목
		this.setTitle("첫번째 프레임");
		
		//창의 크기
		setSize(300,300);
		
		//배치관리자 설정 -버튼크기결정
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
		
		//배경색 변경
		c.setBackground(Color.ORANGE);
		
		//컨텐트팬에 버튼을 추가
		c.add(button1);
		c.add(new JButton("취소"));
		c.add(new JButton("닫기"));
		
		//화면에 보이기
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		 
		new MyFrame();
	}

}
