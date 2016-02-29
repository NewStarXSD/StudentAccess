package zxg2013329700013.access;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StuTable extends JFrame{
		
	JTable info;
	
	TableModel model;
	
	Vector<String> colname = new Vector<String>();
	Vector<Vector<String>> row = new Vector<Vector<String>>();
	
	JDBC Stu = new JDBC();
	
	StuTable(){
		setTitle("张雪鸽 2013329700013");
		setBounds(100, 100, 500, 500);
		Student[] stu = Stu.search();
		int i;
		for(i=0;stu[i].flag!=false;++i){
			Vector<String> tmp = new Vector<String>();
			tmp.add(stu[i].cn);
			tmp.add(stu[i].Sno);
			tmp.add(stu[i].Sname);
			if(stu[i].grade!=-1){
				tmp.add(stu[i].grade+"");
			}else {
				tmp.add("未有成绩");
			}
			tmp.add(stu[i].Sage+"");
			tmp.add(stu[i].Ssex);
			tmp.add(stu[i].Skey);
			row.add(tmp);
		}
		Vector<String> tmp = new Vector<String>();
		tmp.add(stu[i].cn);
		tmp.add(stu[i].Sno);
		tmp.add(stu[i].Sname);
		if(stu[i].grade!=-1){
			tmp.add(stu[i].grade+"");
		}else {
			tmp.add("未有成绩");
		}
		tmp.add(stu[i].Sage+"");
		tmp.add(stu[i].Ssex);
		tmp.add(stu[i].Skey);
		row.add(tmp);
		
		colname.add("课程编号");
		colname.add("学号");
		colname.add("学生姓名");
		colname.add("成绩");
		colname.add("学生年龄");
		colname.add("学生性别");
		colname.add("密码");
		
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
