package zxg2013329700013.access;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	JLabel Id = new JLabel();
	JLabel Key = new JLabel();

	JTextField id = new JTextField(10);
	JPasswordField key = new JPasswordField(10);

	JButton log = new JButton("登陆");

	String[] Kind = { "学生", "教师", "管理员" };

	JComboBox<?> kind = new JComboBox<Object>(Kind);

	JPanel yh = new JPanel();
	JPanel mm = new JPanel();

	Login() {
		super();
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 200, 200);

		setLayout(new FlowLayout());

		yh.add(Id);
		yh.add(id);

		mm.add(Key);
		mm.add(key);

		Id.setText("用户名");
		Key.setText("密码");

		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = kind.getSelectedItem().toString();
				String yonghu = id.getText();
				String mima = new String(key.getPassword());
				if(k.equals("学生")){
					new StudentOp(yonghu,mima);
				}else if(k.equals("教师")){
					new TeacherOp(yonghu,mima);
				}else if(k.equals("管理员")){
					new AdminOp(yonghu,mima);
				}
			}
		});

		add(yh);
		add(mm);
		add(kind);
		add(log);
	}

}
