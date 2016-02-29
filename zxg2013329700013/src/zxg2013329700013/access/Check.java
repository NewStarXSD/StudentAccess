package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Check extends JFrame{
	
	JDBC Stu = new JDBC();

	JComboBox Class ;
	
	JButton ok = new JButton("»∑»œ");
	
	Check(Student stu){
		setTitle("’≈—©∏Î 2013329700013");
		setBounds(100, 100, 400, 80);
		setLayout(new FlowLayout());
		Class = new JComboBox(stu.Class);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = Class.getSelectedIndex();
				int grade = Stu.searchGrade(stu.Sno, stu.Cno[k]);
				new Grade(grade);
			}
		});
		
		add(Class);
		add(ok);
		setVisible(true);
	}
}
