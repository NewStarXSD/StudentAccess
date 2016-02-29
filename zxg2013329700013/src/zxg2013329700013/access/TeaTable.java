package zxg2013329700013.access;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TeaTable extends JFrame {

	JTable info;

	TableModel model;

	Vector<String> colname = new Vector<String>();
	Vector<Vector<String>> row = new Vector<Vector<String>>();

	JDBC Stu = new JDBC();

	TeaTable() {
		setTitle("��ѩ�� 2013329700013");
		setBounds(100, 100, 500, 500);
		Teacher[] tea = Stu.searcht();
		int i;
		for (i = 0; tea[i].flag != false; ++i) {
			Vector<String> tmp = new Vector<String>();
			tmp.add(tea[i].cn);
			tmp.add(tea[i].Tno);
			tmp.add(tea[i].Tname);
			tmp.add(tea[i].Tage + "");
			tmp.add(tea[i].Tsex);
			tmp.add(tea[i].Tkey);
			row.add(tmp);
		}
		Vector<String> tmp = new Vector<String>();
		tmp.add(tea[i].cn);
		tmp.add(tea[i].Tno);
		tmp.add(tea[i].Tname);
		tmp.add(tea[i].Tage + "");
		tmp.add(tea[i].Tsex);
		tmp.add(tea[i].Tkey);
		row.add(tmp);

		colname.add("�γ̱��");
		colname.add("�̹���");
		colname.add("��ʦ����");
		colname.add("��ʦ����");
		colname.add("��ʦ�Ա�");
		colname.add("����");

		model = new DefaultTableModel(row, colname);
		info = new JTable();
		info.setModel(model);
		info.getTableHeader();
		info.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane table = new JScrollPane(info);
		add(table);
		setVisible(true);
	}
}
