package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DelStu extends JFrame{
	
	JDBC Stu = new JDBC();
	
	JLabel num = new JLabel("ѧ��");
	
	JTextField Sno = new JTextField(10);
	
	JButton ok = new JButton("ȷ��");
	
	DelStu(){
		setTitle("��ѩ�� 2013329700013");
		setBounds(100,100,200,100);
		setLayout(new FlowLayout());
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = Sno.getText();
				Stu.deleteStu(sno);
			}
		});
		
		add(num);
		add(Sno);
		add(ok);
		setVisible(true);
	}
}
