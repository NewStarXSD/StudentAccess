package zxg2013329700013.access;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Grade extends JFrame{
	Grade(int g){
		JLabel grade;
		if (g == -1) {
			grade = new JLabel("Œ¥”–≥…º®");
		}else {
			grade = new JLabel(Integer.toString(g));
		}
		setTitle("’≈—©∏Î 2013329700013");
		setBounds(100,100,100,100);
		add(grade);
		setVisible(true);
	}
}
