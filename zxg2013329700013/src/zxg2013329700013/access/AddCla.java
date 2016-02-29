package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCla extends JFrame{
	
	JDBC Stu = new JDBC();
	
	JLabel num = new JLabel("课程编号");
	JLabel name = new JLabel("课程名");	
	JLabel ton = new JLabel("教师教工号");
	
	JTextField Cno = new JTextField(10);
	JTextField Cname = new JTextField(10);
	JTextField Ton = new JTextField(10);
	
	JPanel no = new JPanel();
	JPanel na = new JPanel();
	JPanel ag = new JPanel();
	
	JButton ok = new JButton("确认");
	
	AddCla(){
		setTitle("张雪鸽 2013329700013");
		setBounds(100,100,200,280);
		setLayout(new FlowLayout());
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = Cno.getText();
				String cname = Cname.getText();
				String ttno = Ton.getText();
				Stu.insertClass(cno, cname, ttno);
			}
		});
		
		no.add(num);
		no.add(Cno);
		na.add(name);
		na.add(Cname);
		ag.add(ton);
		ag.add(Ton);
		add(no);
		add(na);
		add(ag);
		add(ok);
		setVisible(true);
	}
}
