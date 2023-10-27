package ex03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuEx extends JFrame implements ActionListener {
	private Container con = getContentPane();
	private Vector<JMenuItem> vecItem = new Vector<>();
	private JLabel label = new JLabel();
	
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴 예제");
		setSize(500, 500);
		con.add(label);
		createMenu();
		setListener();
		setVisible(true);
	}
	
	private void setListener() {
		for (int i = 0; i < vecItem.size(); i++) {
			JMenuItem item = vecItem.get(i);
			item.addActionListener(this);
		}
	}

	private void createMenu() {
		// 메뉴바 - 프레임에 붙일
		JMenuBar menuBar = new JMenuBar();
		
		// 메뉴 - 메뉴바에 붙일
		JMenu mnuScreen = new JMenu("Screen");
		JMenu mnuEdit = new JMenu("Edit");
		JMenu mnuSource = new JMenu("Source");
		JMenu mnuProject = new JMenu("Project");
		JMenu mnuRun = new JMenu("Run");
		
		// 메뉴바에 메뉴들 붙이기
		menuBar.add(mnuScreen);
		menuBar.add(mnuEdit);
		menuBar.add(mnuSource);
		menuBar.add(mnuProject);
		menuBar.add(mnuRun);
		
		// Screen 메뉴에 붙일 아이템들
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miHide = new JMenuItem("Hide");
		JMenuItem miReshow = new JMenuItem("Reshow");
		JMenuItem miExit = new JMenuItem("Exit");
		vecItem.add(miLoad);
		vecItem.add(miHide);
		vecItem.add(miReshow);
		vecItem.add(miExit);
		
		// Screen 메뉴에 아이템 달기
		mnuScreen.add(miLoad);
		mnuScreen.add(miHide);
		mnuScreen.add(miReshow);
		mnuScreen.addSeparator(); // 분리선
		mnuScreen.add(miExit);
		
		// 프레임에 메뉴바 붙이기
		setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		new MenuEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JMenuItem item = (JMenuItem)obj;
		String command = item.getActionCommand(); // 메뉴아이템 글자
		switch (command) {
		case "Load":
			label.setIcon(new ImageIcon("images/image0.jpg"));
			break;
		case "Hide":
			label.setVisible(false);
			break;
		case "Reshow":
			label.setVisible(true);
			break;
		case "Exit":
			System.exit(0);
			break;
		}
		
	}

}