package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpGrade extends JFrame{
	
	JDBC Stu = new JDBC();

	JLabel Cname = new JLabel("课程名");
	JLabel Sno = new JLabel("学号");
	JLabel gr = new JLabel("打分");
	
	JPanel name = new JPanel();
	JPanel num = new JPanel();
	JPanel Mark = new JPanel();
	
	JTextField sno = new JTextField(10);
	JTextField mark = new JTextField(10);
	
	JComboBox Class = new JComboBox();

	JButton ok = new JButton("确认");
	
	UpGrade(Teacher tea){

		for(int i=0;i<tea.classcnt;++i){
			Class.addItem(tea.Class[i]);
		}
		setTitle("张雪鸽 2013329700013");
		setBounds(100,100,300,150);
		setLayout(new FlowLayout());
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S = sno.getText();
				int k = Class.getSelectedIndex();
				String s = mark.getText();
				if(s==null||S==null){
					new False();
					return ;
				}
				int i =Integer.parseInt(s);
				Stu.updategrade(tea.Cno[k], S, i);
				new Success();
			}
		});
		
		name.add(Cname);
		name.add(Class);
		num.add(Sno);
		num.add(sno);
		Mark.add(gr);
		Mark.add(mark);
		add(name);
		add(num);
		add(Mark);
		add(ok);
		
		setVisible(true);
	}
}
