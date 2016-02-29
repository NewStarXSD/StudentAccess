package zxg2013329700013.access;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TeacherTable extends JFrame {

	JTable info;

	TableModel model;

	Vector<String> colname = new Vector<String>();
	Vector<Vector<String>> row = new Vector<Vector<String>>();

	JDBC Stu = new JDBC();

	TeacherTable() {
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 500, 500);
		Teacher[] tea = Stu.searchp2();
		int i;
		for (i = 0; tea[i].flag != false; ++i) {
			Vector<String> tmp = new Vector<String>();
			tmp.add(tea[i].Tno);
			tmp.add(tea[i].Tname);
			tmp.add(tea[i].Tage + "");
			tmp.add(tea[i].Tsex);
			row.add(tmp);
		}
		Vector<String> tmp = new Vector<String>();
		tmp.add(tea[i].Tno);
		tmp.add(tea[i].Tname);
		tmp.add(tea[i].Tage + "");
		tmp.add(tea[i].Tsex);
		row.add(tmp);

		colname.add("教工号");
		colname.add("教师姓名");
		colname.add("教师年龄");
		colname.add("教师性别");

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
