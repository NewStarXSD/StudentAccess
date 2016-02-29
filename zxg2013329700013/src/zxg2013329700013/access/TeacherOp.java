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

	JButton search = new JButton("��ѯ���̿γ�");
	JButton ukey = new JButton("�޸�����");
	JButton grades = new JButton("�Ǽǳɼ�");

	JPanel but = new JPanel();

	TeacherOp(String id, String key) {
		super();
		if (StudentLog(id, key)) {
			setTitle("��ѩ�� 2013329700013");
			setBounds(100, 100, 400, 400);
			setLayout(new GridLayout(5, 1));
			Teacher tea = Stu.searchteacherbyt(id);

			Tname.setText("��ʦ������" + tea.Tname);
			Tno.setText("�̹��ţ�" + tea.Tno);
			Tex.setText("�Ա�" + tea.Tsex);
			Tage.setText("���䣺" + tea.Tage);
			
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
