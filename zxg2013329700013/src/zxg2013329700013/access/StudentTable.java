package zxg2013329700013.access;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentTable extends JFrame{
		
	JTable info;
	
	TableModel model;
	
	Vector<String> colname = new Vector<String>();
	Vector<Vector<String>> row = new Vector<Vector<String>>();
	
	JDBC Stu = new JDBC();
	
	StudentTable(){
		setTitle("��ѩ�� 2013329700013");
		setBounds(100, 100, 500, 500);
		Student[] stu = Stu.searchp();
		int i;
		for(i=0;stu[i].flag!=false;++i){
		Vector<String> tmp = new Vector<String>();
			tmp.add(stu[i].Sno);
			tmp.add(stu[i].Sname);
			tmp.add(stu[i].Sage+"");
			tmp.add(stu[i].Ssex);
			row.add(tmp);
		}
		Vector<String> tmp = new Vector<String>();
		tmp.add(stu[i].Sno);
		tmp.add(stu[i].Sname);
		tmp.add(stu[i].Sage+"");
		tmp.add(stu[i].Ssex);
		row.add(tmp);
		
		colname.add("ѧ��");
		colname.add("ѧ������");
		colname.add("ѧ������");
		colname.add("ѧ���Ա�");
		
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
