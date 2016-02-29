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

	JButton search = new JButton("��ѯ��ѡ�γ�");
	JButton ukey = new JButton("�޸�����");
	JButton choose = new JButton("ѡ��");
	JButton grades = new JButton("��ѯ�ɼ�");

	JPanel but = new JPanel();

	StudentOp(String id, String key) {
		super();
		if (StudentLog(id, key)) {
			setTitle("��ѩ�� 2013329700013");
			setBounds(100, 100, 400, 400);
			setLayout(new GridLayout(5, 1));
			Student stu = Stu.searchstu(id);

			Sname.setText("ѧ��������" + stu.Sname);
			Sno.setText("ѧ�ţ�" + stu.Sno);
			Sex.setText("�Ա�" + stu.Ssex);
			Sage.setText("���䣺" + stu.Sage);

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
