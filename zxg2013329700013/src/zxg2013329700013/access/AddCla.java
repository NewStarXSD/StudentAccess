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
	
	JLabel num = new JLabel("�γ̱��");
	JLabel name = new JLabel("�γ���");	
	JLabel ton = new JLabel("��ʦ�̹���");
	
	JTextField Cno = new JTextField(10);
	JTextField Cname = new JTextField(10);
	JTextField Ton = new JTextField(10);
	
	JPanel no = new JPanel();
	JPanel na = new JPanel();
	JPanel ag = new JPanel();
	
	JButton ok = new JButton("ȷ��");
	
	AddCla(){
		setTitle("��ѩ�� 2013329700013");
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
