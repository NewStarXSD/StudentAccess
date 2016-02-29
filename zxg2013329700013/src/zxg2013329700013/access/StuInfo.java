package zxg2013329700013.access;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StuInfo extends JFrame{
		
	JTable info;
	
	TableModel model;
	
	Vector<String> colname = new Vector<String>();
	Vector<Vector<String>> row = new Vector<Vector<String>>();
	
	JDBC Stu = new JDBC();
	
	StuInfo(String Sno){
		setTitle("��ѩ�� 2013329700013");
		setBounds(100, 100, 500, 500);
		Student stu = Stu.searchstu(Sno);
		for(int i=0;i<stu.classcnt;++i){
			Teacher item = Stu.searchteacher(stu.Cno[i]);
			Vector<String> tmp = new Vector<String>();
			tmp.add(stu.Cno[i]);
			tmp.add(stu.Class[i]);
			tmp.add(item.Tname);
			tmp.add(item.Tno);
			row.add(tmp);
		}
		colname.add("�γ̱��");
		colname.add("�γ���");
		colname.add("��ʦ����");
		colname.add("�̹���");
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
