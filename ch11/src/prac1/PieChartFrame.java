package prac1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PieChartFrame extends JFrame implements ActionListener {
	private Container con = getContentPane();
	private String[] fruits = {"apple", "cherry", "strawberry", "prune"};
	private JTextField[] tfFruits = new JTextField[fruits.length];
	private int[] saleCounts = new int[fruits.length];
	private int[] percents = new int[fruits.length];
	private int[] angles = new int[fruits.length];
	private Color[] colors = {
			Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE
	};
	private ChartPanel chartPanel = new ChartPanel();
	
	public PieChartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("파이 차트 그리기");
		setSize(700, 500);
		setUI();
		setVisible(true);
		
	}

	private void setUI() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < fruits.length; i++) {
			panel.add(new JLabel(fruits[i]));
			// System.out.println(tfFruits[0]);
			tfFruits[i] = new JTextField("0", 5);
			tfFruits[i].addActionListener(this);
			panel.add(tfFruits[i]);
		}
		
		con.add(panel, BorderLayout.NORTH);
		con.add(chartPanel, BorderLayout.CENTER);
	}
	
	public class ChartPanel extends JPanel {
		private static final int CIRCLE_SIZE = 250;
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			System.out.println("paintComponent");
			drawPercent(g);
			if (getTotal() != 0) {
				drawPie(g);
			}
			
		}
		
		private void drawPie(Graphics g) {
			int panelWidth = this.getWidth();
			int panelHeight = this.getHeight();
			int cx = (panelWidth / 2) - (CIRCLE_SIZE / 2);
			int cy = (panelHeight / 2) - (CIRCLE_SIZE/ 2);
			int startAngle = 0;
			for (int i = 0; i < fruits.length; i++) {
				g.setColor(colors[i]);
				int angle = angles[i];
				if (i == fruits.length - 1) {
					angle = 360 - startAngle;
				}
				g.fillArc(cx, cy + 50, CIRCLE_SIZE, CIRCLE_SIZE, startAngle, angle);
				startAngle += angles[i];
			}
			
		}

		public void drawPercent(Graphics g) {
			for (int i = 0; i < fruits.length; i++) {
				g.setColor(colors[i]);
				g.drawString(fruits[i] + " " + percents[i] + "%", 100 + (i * 130), 50);
			}
			
			
		}
	}

	public static void main(String[] args) {
		new PieChartFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setSaleCounts();
		int total = getTotal();
		setPercents(total);
		setAngles(total);
		showPercentsAndAngles();
		chartPanel.repaint();
	}
	
	private void showPercentsAndAngles() {
		System.out.println("percents");
		for (int i = 0; i < percents.length; i++) {
			System.out.printf("%d%% \n", percents[i]);
		}
		System.out.println("angles");
		for (int i = 0; i < angles.length; i++) {
			System.out.printf("%d도 \n", angles[i]);
		}
	}

	private void setAngles(int total) {
		for (int i = 0; i < angles.length; i++) {
			angles[i] = 360 * saleCounts[i] / total;
		}
	}

	private void setPercents(int total) {
		// 2 : 10 = ? : 100
		// 10 * ? = 100 * 2
		// ? = 100 * 2 / 10
		for (int i = 0; i < percents.length; i++) {
			percents[i] = 100 * saleCounts[i] / total;
		}
		
		
	}
	
	private void setSaleCounts() {
		
		for (int i = 0; i < tfFruits.length; i++) {
			try {
				saleCounts[i] =  Integer.parseInt(tfFruits[i].getText());
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(PieChartFrame.this, 
						"숫자만 입력해주세요", "에러", JOptionPane.ERROR_MESSAGE);
				tfFruits[i].requestFocus();
				return;
			}
		}
		
	}

	private int getTotal() {
		int total = 0;
		for (int i = 0; i < tfFruits.length; i++) {
			total += saleCounts[i];
		}
		
		return total;
	}

	

}