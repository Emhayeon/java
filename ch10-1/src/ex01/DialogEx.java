
package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DialogEx extends JFrame {

        Container con = getContentPane();
        private JButton btnClick = new JButton("클릭");

        public DialogEx() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("다이얼로그 예제");
                setSize(300, 300);
                con.add(btnClick);
                btnClick.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                MyDialog myDialog = new MyDialog();
                                myDialog.setVisible(true);
                        }
                });

                setVisible(true);
        }

        class MyDialog extends JDialog {

                private JTextField txtName = new JTextField(10);
                private JButton btnOk = new JButton("OK");

                public MyDialog() {
                        setTitle("마이 다이얼로그");
                        setSize(300, 200);
                        // 다이얼로그의 기본배치 - 보더 레이아웃
                        setLayout(new FlowLayout());
                        this.add(txtName);
                        this.add(btnOk);
                        btnOk.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        String name = txtName.getText();
                                        btnClick.setText(name);
                                        // MyDialog.this.dispose();
                                        MyDialog.this.setVisible(false);
                                }
                        });
                }
        }

        public static void main(String[] args) {
                new DialogEx();

        }

}
