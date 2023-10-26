package ex03;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame{
	
	private Container con = getContentPane();//new (x)
	
	public GridLayoutEx() {
		// 창닫기 버튼 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//창의 제목
		this.setTitle("그리드 레이아웃 예제");
		
		//창의 크기
		this.setSize(500, 200);
		
		//UI 설정
		this.setUI();
		
		//화면보이기
		this.setVisible(true);
	}
	

	private void setUI() {
		// 컨테이너의 기본 배치 관리자 -보더 레이아웃
		con.setLayout(new GridLayout(2, 5, 5, 10));
		for(int i = 1; i <= 10; i++) {
			con.add(new JButton(String.valueOf(i)));//버튼 컨포넌트생성->숫자를 문자로 변환
		}
		
	}


	public static void main(String[] args) {
		new GridLayoutEx();

	}

}
