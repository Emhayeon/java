package ex08;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TabAndThreadEx extends JFrame {

        Container con = getContentPane();
        private MyLabel label = new MyLabel();
        int barSize = 200; // 변수지정

        public TabAndThreadEx() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("아무키나 빨리눌러 바 채우기");
                setSize(500, 200);
                setVisible(true);

                con.setLayout(null);
                label.setOpaque(true);
                label.setBackground(Color.ORANGE);
                label.setBounds(50, 50, 400, 50);
                con.add(label);
                con.setFocusable(true); // 키이벤트 준비
                con.requestFocus(); // 키이벤트 준비
                con.addKeyListener(new KeyAdapter() {

                        @Override
                        public void keyReleased(KeyEvent e) {
                                synchronized (label) {
                                        if (barSize == 400) {
                                                return; // 밑에꺼 실행하지 않아야함
                                        }
                                        barSize++;
                                        label.repaint();
                                        label.notify();
                                }

                        }
                });

                Thread th = new Thread(label);
                th.start();

        }

        public class MyLabel extends JLabel implements Runnable {

                @Override
                protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(Color.MAGENTA);
                        g.fillRect(0, 0, barSize, 50);
                }

                @Override
                public void run() {
                        while (true) {
                                try {
                                        Thread.sleep(900);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                                synchronized (this) {
                                        barSize--;
                                        System.out.println(barSize);
                                        repaint();
                                        if (barSize == 0) {
                                                try {
                                                        System.out.println("대기전");
                                                        wait();
                                                        System.out.println("대기후");
                                                } catch (InterruptedException e) {
                                                        e.printStackTrace();
                                                }
                                        }

                                }
                        }
                }
        }

        public static void main(String[] args) {
                new TabAndThreadEx();

        }

}
