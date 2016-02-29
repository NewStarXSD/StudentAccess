package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DelTea extends JFrame{
	
	JDBC Stu = new JDBC();
	
	JLabel num = new JLabel("教工号");
	
	JTextField Tno = new JTextField(10);
	
	JButton ok = new JButton("确认");
	
	DelTea(){
		setTitle("张雪鸽 2013329700013");
		setBounds(100,100,200,100);
		setLayout(new FlowLayout());
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tno = Tno.getText();
				Stu.deleteTea(tno);
				new Success();
			}
		});
		
		add(num);
		add(Tno);
		add(ok);
		setVisible(true);
	}
}
