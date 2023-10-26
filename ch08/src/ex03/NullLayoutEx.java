package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NullLayoutEx extends JFrame{
	
	Container con = getContentPane();
	JPanel pn1Left = new JPanel();
	JPanel pn1Right = new JPanel();
	
	public NullLayoutEx() {
		//창닫기버튼
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//창제목
		this.setTitle("널레이아웃 예제");
		//창크기
		this.setSize(500, 500);
		
		//UI설정
		setUI();
		
		
		//창보이기
		this.setVisible(true);
	}

	private void setUI() {
		//컨테이너의 배치관리자 설정 - 그리드 레이아웃 (1x2)
		con.setLayout(new GridLayout(1, 2, 10, 10));
		setLeft();
		setRight();
		//컨테이너에 패널 달기
		con.add(pn1Left);
		con.add(pn1Right);
		
		
		
	}
	
	private void setLeft() {
		//왼쪽 패널의 레이아웃 설정-플로우 레이아웃
		pn1Left.setLayout(new FlowLayout());
		//왼쪽 패널의 배경색을 오렌지 색으로 설정
		pn1Left.setBackground(Color.ORANGE);
		//버튼 2개 달기("확인","취소")
		pn1Left.add(new JButton("확인"));
		pn1Left.add(new JButton("취소"));
		
	}
	private void setRight() {
		//오른쪽 패널의 배치관리자를 없앰-> Null 설정하면됨
		pn1Right.setLayout(null);
		//오른쪽 패널의 배경색 녹색으로 설정
		pn1Right.setBackground(Color.GREEN);
		//버튼을 10개 달기
		//패널에 배치관리자가 없다 ->버튼들의 크기와 위치 설정
		for(int i = 1; i <= 10; i++ ) {
			JButton button = new JButton(String.valueOf(i));
			
			//크기 설정
			//button.setSize(100, 50);
			//버튼 위치설정
			//button.setLocation(i * 20, i * 20);
			
			//크기와 위치 같이 설정
			button.setBounds(i * 20, i * 20, 100, 50);
			
			//패널에 버튼달기
			pn1Right.add(button);
			//
		
			
			
		}
	}

	public static void main(String[] args) {
		new NullLayoutEx();

	}

}
