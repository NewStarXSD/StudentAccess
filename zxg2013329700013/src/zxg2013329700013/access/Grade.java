package zxg2013329700013.access;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Grade extends JFrame{
	Grade(int g){
		JLabel grade;
		if (g == -1) {
			grade = new JLabel("δ�гɼ�");
		}else {
			grade = new JLabel(Integer.toString(g));
		}
		setTitle("��ѩ�� 2013329700013");
		setBounds(100,100,100,100);
		add(grade);
		setVisible(true);
	}
}
