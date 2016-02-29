package zxg2013329700013.access;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminOp extends JFrame {
	JDBC Stu = new JDBC();

	JButton Studel = new JButton("删除学生信息");
	JButton Stuadd = new JButton("新增学生信息");
	JButton Teadel = new JButton("删除教师信息");
	JButton Teaadd = new JButton("新增教师信息");
	JButton ukey = new JButton("修改密码");
	JButton Claadd = new JButton("新增课程");
	JButton Cladel = new JButton("删除课程");
	JButton back = new JButton("退课");
	JButton showstu = new JButton("学生选课信息");
	JButton showtea = new JButton("教师任课信息");
	JButton showStu = new JButton("学生名单");
	JButton showTea = new JButton("教师名单");

	AdminOp(String id, String key) {
		super();
		if (AdminLog(id, key)) {
			setTitle("张雪鸽 2013329700013");
			setBounds(100, 100, 400, 350);
			setLayout(new GridLayout(5, 1));

			ukey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ChangeAKey(id);
				}
			});
			
			Studel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DelStu();
				}
			});
			
			Teadel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DelTea();
				}
			});
			
			Stuadd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddStu();
				}
			});
			
			Teaadd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddTea();
				}
			});
			
			Claadd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddCla();
				}
			});
			
			Cladel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DelCla();
				}
			});
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Back();
				}
			});
			
			showstu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new StuTable();
				}
			});
			
			showtea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TeaTable();
				}
			});
			
			showStu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new StudentTable();
				}
			});
			
			showTea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TeacherTable();
				}
			});
			
			add(showstu);
			add(showtea);
			add(showStu);
			add(showTea);
			add(Studel);
			add(Stuadd);
			add(Teadel);
			add(Teaadd);
			add(ukey);
			add(Claadd);
			add(Cladel);
			add(back);
			setVisible(true);
		}
	}

	boolean AdminLog(String id, String key) {
		String itemkey = Stu.searchadminkey(id);
		if (itemkey.equals(null) || !itemkey.equals(key)) {
			return false;
		}
		return true;
	}
}
