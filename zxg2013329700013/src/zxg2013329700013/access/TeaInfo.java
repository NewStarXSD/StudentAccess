package zxg2013329700013.access;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TeaInfo extends JFrame{
		
	JTable info;
	
	TableModel model;
	
	Vector<String> colname = new Vector<String>();
	Vector<Vector<String>> row = new Vector<Vector<String>>();
	
	JDBC Stu = new JDBC();
	
	TeaInfo(Teacher tea){
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 500, 500);
		for(int i=0;i<tea.classcnt;++i){
			Student stu;
			String[] student = Stu.searchst(tea.Cno[i]);
			for (int j = 0; student[j] != null; ++j) {
				stu = Stu.searchstu(student[j]);		
				Vector<String> tmp = new Vector<String>();		
				tmp.add(tea.Cno[i]);
				tmp.add(tea.Class[i]);
				tmp.add(stu.Sname);
				tmp.add(stu.Sno);
				row.add(tmp);
			}
		}
		colname.add("课程编号");
		colname.add("课程名");
		colname.add("学生姓名");
		colname.add("学号");
		model = new DefaultTableModel(row,colname);
		info = new JTable();
		info.setModel(model);
		info.getTableHeader();
		info.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

		JScrollPane table = new JScrollPane(info); 
		add(table);
		setVisible(true);
	}
}
