package guessnum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessNumFrame extends JFrame implements ActionListener {
	private GameManager manager = GameManager.getInstance();
	private static final String START_MESSAGE 
		= "1~100 사이의 임의의 숫자를 맞춰보세요\n";
	private Container con = getContentPane();
	private MyLabel barLabel = new MyLabel();
	int barSize=100;
	private JFileChooser chooser = new JFileChooser();
	
	
	
	// North
	private JPanel pnlNorth = new JPanel();
	private JTextField tfInput = new JTextField(5);
	private JLabel lblInput = new JLabel("입력:");
	private JButton btnInput = new JButton("입력");
	private JLabel lblRecord = new JLabel("기록:");
	private JTextField tfRecord = new JTextField("30000");
	private JButton btnNewGame = new JButton("새게임");
	
	// Center
	private JTextArea taMessage = new JTextArea(START_MESSAGE);
	
	// South
	private JPanel pnlSouth = new JPanel();
	private JLabel lblCount = new JLabel("남은횟수:");
	private JTextField tfCount = new JTextField(7);
	private JPanel pnlBar = new JPanel();
	private JPanel pnlCount = new JPanel();
	
	
	private long startTime;
	private long endTime;
	
	public GuessNumFrame( ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자맞추기");
		setSize(700, 500);
		setUI();
		setListener();
		setVisible(true);
		startEnabled();
		init();
		
		Thread th = new Thread(barLabel);
		th.start();
	}
	
	private void save() {
//		int result = chooser.showSaveDialog(null);
//		if(result == JFileChooser.APPROVE_OPTION) {
//			String recordTime = chooser.getSelectedFile().getPath();
//			
//		}
		
	}

	private void exitOneGame() {
		tfInput.setEnabled(false);
		btnInput.setEnabled(false);
	}

	private void setListener() {
		tfInput.addActionListener(this);
		btnInput.addActionListener(this);
		btnNewGame.addActionListener(this);
		
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}
	private void setNorth() {
		pnlNorth.setBackground(Color.MAGENTA);
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		pnlNorth.add(btnInput);
		pnlNorth.add(lblRecord);
		pnlNorth.add(tfRecord);
		pnlNorth.add(btnNewGame);
		con.add(pnlNorth, BorderLayout.NORTH);
	}

	private void setCenter() {
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		taMessage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
	private void setSouth() {
		pnlSouth.setLayout(new GridLayout(1,2));
		
		pnlSouth.add(pnlCount);
		pnlCount.add(lblCount);
		pnlCount.add(tfCount);
		pnlCount.setBackground(Color.CYAN);
		pnlBar.setBackground(Color.CYAN);
		barLabel.setBackground(Color.YELLOW);
		pnlBar.setLayout(null);
		barLabel.setOpaque(true);
		barLabel.setSize(100,20);
		barLabel.setLocation(40, 5);
		pnlSouth.add(pnlBar);
		pnlBar.add(barLabel);
		con.add(pnlSouth, BorderLayout.SOUTH);
		
	}
	private void startEnabled() {
		tfInput.setEnabled(false);
		btnInput.setEnabled(false);
	}
	private void init() {
		manager.init();
		tfRecord.setEditable(false);
		taMessage.setEditable(false);
		tfCount.setEditable(false);
		taMessage.setText(START_MESSAGE);
		printHeart();
		
		startTime = System.currentTimeMillis();
	}
	public class MyLabel extends JLabel implements Runnable{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, barSize, 20);
		}
		@Override
		public void run() {
			 while (true) {
                 try {
                         Thread.sleep(40);
                         
                 } catch (InterruptedException e) {
                         e.printStackTrace();
                 }
                 synchronized (this) {
                         barSize--;
                       //  System.out.println(barSize);
                         repaint();
                         
                         if (barSize == 0) {
                        	 	
                                 try {
                                        // System.out.println("대기전");
                                        wait();
                                       
                                	 //tfInput.setText("");
                                	 
                                       //  System.out.println("대기후");
                                 } catch (InterruptedException e) {
                                         e.printStackTrace();
                                 }
                                
                         }
                                	 
                               
                      }

                 }
         }
		
		
	}
	public static void main(String[] args) {
		new GuessNumFrame();

	}
	
	private void printHeart() {
		int count = manager.getCount();
		String heart = "";
		for (int i = 0; i < count; i++) {
			heart += "♥";
//			System.out.println("P:"+heart);
		}
		tfCount.setText(heart);
		
	}
	
	
	private void updateRecord() {
		long elapsedTime = endTime - startTime;
		String strRecord = tfRecord.getText();
		long lRecord = Long.parseLong(strRecord);
		if (elapsedTime < lRecord) {
			tfRecord.setText(String.valueOf(elapsedTime));
		}
	}

	private void appendMessage(int result, int userNum) {
		String resultMessage = "";
		switch (result) {
			case GameManager.RESULT_OK:
				//resultMessage = "----- 정답입니다. -----";
				JOptionPane.showConfirmDialog(GuessNumFrame.this, "정답입니다.", "알림", JOptionPane.CLOSED_OPTION);
				exitOneGame();
				endTime = System.currentTimeMillis();
				JOptionPane.showConfirmDialog(GuessNumFrame.this, "새로운 기록 달성", "알림", JOptionPane.CLOSED_OPTION);
				updateRecord();
/*				int save = chooser.showSaveDialog(null);
				if (save == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					manager.save(path);
				}*/
				break;
			case GameManager.RESULT_BIG:
				resultMessage = "----- " + userNum + " 보다 큽니다. -----";
				break;
			case GameManager.RESULT_SMALL:
				resultMessage = "----- " + userNum + " 보다 작습니다. -----";
				break;
		} // switch
		// System.out.println(resultMessage);
		taMessage.append("\n" + resultMessage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfInput || obj == btnInput) {
			String userInput = tfInput.getText();
			try {
				int userNum = Integer.parseInt(userInput);
				// 범위 체크
				if (1 > userNum || userNum > 100) {
					// taMessage.append("\n1~100 사이의 숫자를 입력해주세요.");
					JOptionPane.showMessageDialog(GuessNumFrame.this, "1~100 사이의 숫자를 입력해주세요.","알림", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int result = manager.judge(userNum);
				appendMessage(result, userNum);
			} catch (NumberFormatException nfe) {
				// taMessage.append("\n 숫자만 입력해주세요.");
				JOptionPane.showMessageDialog(GuessNumFrame.this, "숫자만 입력해 주세요","알림", JOptionPane.ERROR_MESSAGE);
				tfInput.setText("");
				return;
			}
			
			int count = manager.getCount();
			if (count == 0) {
				//taMessage.append("\n 기회를 모두 소진하였습니다.");
				JOptionPane.showMessageDialog(GuessNumFrame.this, "기회를 모두 소진하였습니다.","알림", JOptionPane.ERROR_MESSAGE);
				exitOneGame();
			}
			printHeart();
			
			tfInput.setText("");
		} else if (obj == btnNewGame) {
			tfInput.setEnabled(true);
			btnInput.setEnabled(true);
			init();
		}
		
	}

}