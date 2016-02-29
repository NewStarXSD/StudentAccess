package zxg2013329700013.access;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeacherOp extends JFrame{
	JDBC Stu = new JDBC();

	JLabel Tname = new JLabel();
	JLabel Tno = new JLabel();
	JLabel Tex = new JLabel();
	JLabel Tage = new JLabel();

	JButton search = new JButton("查询所教课程");
	JButton ukey = new JButton("修改密码");
	JButton grades = new JButton("登记成绩");

	JPanel but = new JPanel();

	TeacherOp(String id, String key) {
		super();
		if (StudentLog(id, key)) {
			setTitle("张雪鸽 2013329700013");
			setBounds(100, 100, 400, 400);
			setLayout(new GridLayout(5, 1));
			Teacher tea = Stu.searchteacherbyt(id);

			Tname.setText("教师姓名：" + tea.Tname);
			Tno.setText("教工号：" + tea.Tno);
			Tex.setText("性别：" + tea.Tsex);
			Tage.setText("年龄：" + tea.Tage);
			
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TeaInfo(tea);
				}
			});
			
			ukey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ChangeTKey(id);
				}
			});
			
			grades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new UpGrade(tea);
				}
			});
			
			but.add(search);
			but.add(ukey);
			but.add(grades);

			add(Tname);
			add(Tno);
			add(Tex);
			add(Tage);
			add(but);
			setVisible(true);
		}
	}

	boolean StudentLog(String id, String key) {
		String itemkey = Stu.searchTkey(id);
		if (itemkey.equals(null) || !itemkey.equals(key)) {
			return false;
		}
		return true;
	}
}
