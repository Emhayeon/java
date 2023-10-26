package ex02;

import java.awt.BorderLayout;
import java.awt.Container;


import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {
	
	
	Container c = getContentPane();
	//->배치관리자: BoderLayout
	String[] texts = {"add","sub","mul","div","Calculate"};//버튼이름만 추가하면 버튼추가됨
	String[] positions = {
		BorderLayout.EAST,
		BorderLayout.WEST,
		BorderLayout.SOUTH,
		BorderLayout.NORTH,
		BorderLayout.CENTER
	};
	
	
	public BorderLayoutEx() {
		// 창닫기 버튼 클릭시 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//창의 제목
		this.setTitle("BorderLayoutEx");
		
		//창 사이즈 설정
		setSize(300,200);
		
		
		
		//배치 관리자 설정
		c.setLayout(new BorderLayout(20, 20));
		
		//버튼추가
		for(int i = 0; i<texts.length; i++ ) {
			c.add(new JButton(texts[i]), positions[i]);
		}
		/*
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("calculate"));
		*/
		
		//화면에 보이기
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new BorderLayoutEx();

	}

}
