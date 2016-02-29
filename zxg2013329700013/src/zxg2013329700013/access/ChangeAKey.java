package zxg2013329700013.access;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChangeAKey extends JFrame{
	
	JLabel k1 = new JLabel("新密码：");
	JLabel k2 = new JLabel("请确认：");
	
	JPasswordField key1 = new JPasswordField(10);
	JPasswordField key2 = new JPasswordField(10);
	
	JPanel ke1 = new JPanel();
	JPanel ke2 = new JPanel();
	
	JButton ok = new JButton("确认");
	
	JDBC Stu = new JDBC();
	
	ChangeAKey(String admin){
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 200, 200);
		setLayout(new GridLayout(3,1));
		
		ke1.add(k1);
		ke1.add(key1);
		
		ke2.add(k2);
		ke2.add(key2);
		
		ok.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String K1 = new String(key1.getPassword());
				String K2 = new String(key2.getPassword());
				if(K1.equals(K2)){
					Stu.updatedaminkey(admin, K2);
					new Success();
				}else {
					new False();
				}
			}
		});
		
		add(ke1);
		add(ke2);
		add(ok);
		
		setVisible(true);
	}
}
