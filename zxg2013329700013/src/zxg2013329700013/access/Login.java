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

	JButton log = new JButton("��½");

	String[] Kind = { "ѧ��", "��ʦ", "����Ա" };

	JComboBox<?> kind = new JComboBox<Object>(Kind);

	JPanel yh = new JPanel();
	JPanel mm = new JPanel();

	Login() {
		super();
		setTitle("��ѩ�� 2013329700013");
		setBounds(100, 100, 200, 200);

		setLayout(new FlowLayout());

		yh.add(Id);
		yh.add(id);

		mm.add(Key);
		mm.add(key);

		Id.setText("�û���");
		Key.setText("����");

		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = kind.getSelectedItem().toString();
				String yonghu = id.getText();
				String mima = new String(key.getPassword());
				if(k.equals("ѧ��")){
					new StudentOp(yonghu,mima);
				}else if(k.equals("��ʦ")){
					new TeacherOp(yonghu,mima);
				}else if(k.equals("����Ա")){
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
