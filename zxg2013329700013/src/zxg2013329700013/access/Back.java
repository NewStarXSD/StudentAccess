package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Back extends JFrame {

	JDBC Stu = new JDBC();

	JLabel num = new JLabel("课程编号");
	JLabel sno = new JLabel("学号");

	JTextField Cno = new JTextField(10);
	JTextField Sno = new JTextField(10);

	JPanel no = new JPanel();
	JPanel na = new JPanel();
	JPanel ag = new JPanel();

	JButton ok = new JButton("确认");

	Back() {
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 200, 280);
		setLayout(new FlowLayout());

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = Cno.getText();
				String sno = Sno.getText();
				Stu.delete(sno, cno);
			}
		});

		no.add(num);
		no.add(Cno);
		na.add(sno);
		na.add(Sno);
		add(no);
		add(na);
		add(ok);
		setVisible(true);
	}
}
