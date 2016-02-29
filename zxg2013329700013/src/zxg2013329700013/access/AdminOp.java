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

	JButton Studel = new JButton("ɾ��ѧ����Ϣ");
	JButton Stuadd = new JButton("����ѧ����Ϣ");
	JButton Teadel = new JButton("ɾ����ʦ��Ϣ");
	JButton Teaadd = new JButton("������ʦ��Ϣ");
	JButton ukey = new JButton("�޸�����");
	JButton Claadd = new JButton("�����γ�");
	JButton Cladel = new JButton("ɾ���γ�");
	JButton back = new JButton("�˿�");
	JButton showstu = new JButton("ѧ��ѡ����Ϣ");
	JButton showtea = new JButton("��ʦ�ο���Ϣ");
	JButton showStu = new JButton("ѧ������");
	JButton showTea = new JButton("��ʦ����");

	AdminOp(String id, String key) {
		super();
		if (AdminLog(id, key)) {
			setTitle("��ѩ�� 2013329700013");
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
