package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTea extends JFrame{
	
	JDBC Stu = new JDBC();
	
	JLabel num = new JLabel("教工号");
	JLabel name = new JLabel("姓名");	
	JLabel age = new JLabel("年龄");
	JLabel sex = new JLabel("性别");	
	
	JTextField Sno = new JTextField(10);
	JTextField Sname = new JTextField(10);
	JTextField Sage = new JTextField(10);
	JTextField Ssex = new JTextField(10);
	
	JPanel no = new JPanel();
	JPanel na = new JPanel();
	JPanel ag = new JPanel();
	JPanel se = new JPanel();
	
	JButton ok = new JButton("确认");
	
	AddTea(){
		setTitle("张雪鸽 2013329700013");
		setBounds(100,100,200,300);
		setLayout(new FlowLayout());
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = Sno.getText();
				String sname = Sname.getText();
				int sage = Integer.parseInt(Sage.getText());
				String ssex = Ssex.getText();
				Stu.insertTea(sno, sname, ssex, sage, "123456");
				new Key();
			}
		});
		
		no.add(num);
		no.add(Sno);
		na.add(name);
		na.add(Sname);
		ag.add(age);
		ag.add(Sage);
		se.add(sex);
		se.add(Ssex);
		add(no);
		add(na);
		add(ag);
		add(se);
		add(ok);
		setVisible(true);
	}
}
