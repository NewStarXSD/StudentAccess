package zxg2013329700013.access;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentOp extends JFrame {
	JDBC Stu = new JDBC();

	JLabel Sname = new JLabel();
	JLabel Sno = new JLabel();
	JLabel Sex = new JLabel();
	JLabel Sage = new JLabel();

	JButton search = new JButton("查询所选课程");
	JButton ukey = new JButton("修改密码");
	JButton choose = new JButton("选课");
	JButton grades = new JButton("查询成绩");

	JPanel but = new JPanel();

	StudentOp(String id, String key) {
		super();
		if (StudentLog(id, key)) {
			setTitle("张雪鸽 2013329700013");
			setBounds(100, 100, 400, 400);
			setLayout(new GridLayout(5, 1));
			Student stu = Stu.searchstu(id);

			Sname.setText("学生姓名：" + stu.Sname);
			Sno.setText("学号：" + stu.Sno);
			Sex.setText("性别：" + stu.Ssex);
			Sage.setText("年龄：" + stu.Sage);

			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new StuInfo(id);
				}
			});

			ukey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ChangeKey(id);
				}
			});

			choose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Choose(stu);
				}
			});

			grades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Check(stu);
				}
			});

			but.add(search);
			but.add(ukey);
			but.add(choose);
			but.add(grades);

			add(Sname);
			add(Sno);
			add(Sex);
			add(Sage);
			add(but);
			setVisible(true);
		}
	}

	boolean StudentLog(String id, String key) {
		String itemkey = Stu.searchkey(id);
		if (itemkey.equals(null) || !itemkey.equals(key)) {
			return false;
		}
		return true;
	}
}
