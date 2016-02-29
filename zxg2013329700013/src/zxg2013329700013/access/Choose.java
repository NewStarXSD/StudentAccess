package zxg2013329700013.access;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Choose extends JFrame {

	JDBC Stu = new JDBC();

	JLabel Cname = new JLabel("课程名");

	JComboBox Class = new JComboBox();

	JButton ok = new JButton("确认");

	Choose(Student stu) {
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 400, 80);
		GridLayout style = new GridLayout(1, 3);
		style.setHgap(10);
		setLayout(style);
		CClass[] classlist = Stu.searchclass();
		int i = 0;
		while (classlist[i].flag) {
			Class.addItem(classlist[i].Cname);
			i++;
		}
		Class.addItem(classlist[i].Cname);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				int k = Class.getSelectedIndex();
				for (int i = 0; i < stu.classcnt; ++i) {
					if (stu.Class[i].equals(classlist[k].Cname)) {
						flag = false;
						new False();
						return;
					}
				}
				if (flag) {
					Stu.insertSC(stu.Sno,classlist[k].Cno);
					new Success();
				}
			}
		});

		add(Cname);
		add(Class);
		add(ok);
		setVisible(true);
	}
}
