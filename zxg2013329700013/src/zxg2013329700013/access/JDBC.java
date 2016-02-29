package zxg2013329700013.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Stu";// 数据库路径
	private static final String USERNAME = "sa";// 数据库用户名
	private static final String PASSWORD = "sa";// 数据库用户密码
	private Connection conn = null;
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC驱动——by：张雪鸽 2013329700013");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	JDBC() {
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("建立数据库连接——by：张雪鸽 2013329700013");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 插入
	void insertSC(String Sno, String Cno) {
		try {
			Statement in = conn.createStatement();
			String sql = "insert into Stu_Cla(Cno,Sno,Grade) values(" + "'"
					+ Cno + "'," + "'" + Sno + "',-1)";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void insertStu(String Sno, String Sname, String Ssex, int Sage, String Skey) {
		try {
			Statement in = conn.createStatement();
			String sql = "insert into Student(Sno,Sname,Ssex,Sage) values('"
					+ Sno + "','" + Sname + "','" + Ssex + "','" + Sage + "')";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				sql = "insert into StudentUser(Sno,Skey) values('" + Sno
						+ "','" + Skey + "')";
				lines = in.executeUpdate(sql);
				if (lines != 0) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失敗");
				}
			} else {
				System.out.println("添加失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void insertTea(String Tno, String Tname, String Tsex, int Tage, String Tkey) {
		try {
			Statement in = conn.createStatement();
			String sql = "insert into Teacher(Tno,Tname,Tsex,Tage) values('"
					+ Tno + "','" + Tname + "','" + Tsex + "','" + Tage + "')";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				sql = "insert into TeacherUser(Tno,Tkey) values('" + Tno
						+ "','" + Tkey + "')";
				lines = in.executeUpdate(sql);
				if (lines != 0) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失敗");
				}
			} else {
				System.out.println("添加失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void insertClass(String Cno, String Cname, String Tno) {
		try {
			Statement in = conn.createStatement();
			String sql = "insert into Class(Cno,Cname) values('" + Cno + "','"
					+ Cname + "')";
			in.executeUpdate(sql);
			sql = "insert into Tea_Cla(Cno,Tno) values('" + Cno + "','" + Tno
					+ "')";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除
	void deleteStu(String Sno) {
		try {
			Statement in = conn.createStatement();
			String sql = "delete from StudentUser where Sno = '" + Sno + "'";
			in.executeUpdate(sql);
			sql = "delete from Stu_Cla where Sno = '" + Sno + "'";
			in.executeUpdate(sql);
			sql = "delete from Student where Sno = '" + Sno + "'";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void deleteTea(String Tno) {
		try {
			Statement in = conn.createStatement();
			String sql = "delete from TeacherUser where Tno = '" + Tno + "'";
			in.executeUpdate(sql);
			sql = "delete from Tea_Cla where Tno = '" + Tno + "'";
			in.executeUpdate(sql);
			sql = "delete from Teacher where Tno = '" + Tno + "'";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void deleteClass(String Cno) {
		try {
			Statement in = conn.createStatement();
			String sql = "delete from Tea_Cla where Cno = '" + Cno + "'";
			in.executeUpdate(sql);
			sql = "delete from Stu_Cla where Cno = '" + Cno + "'";
			in.executeUpdate(sql);
			sql = "delete from Class where Cno = '" + Cno + "'";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void delete(String Sno, String Cno) {
		try {
			Statement in = conn.createStatement();
			String sql = "delete from Stu_Cla where Cno = '" + Cno
					+ "' and Sno = '" + Sno + "'";
			int lines = in.executeUpdate(sql);
			if (lines != 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 搜索
	Student[] searchp() {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Student";
			ResultSet rs = in.executeQuery(sql);
			Student[] stu = new Student[100];
			int i = 0;
			while (rs.next()) {
				stu[i] = new Student();
				stu[i].Sno = rs.getString("Sno");
				stu[i].Sname = rs.getString("Sname");
				stu[i].Sage = rs.getInt("Sage");
				stu[i].Ssex = rs.getString("Ssex");
				if (i > 0) {
					stu[i - 1].flag = true;
				}
				++i;
			}
			in.close();
			return stu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	Teacher[] searchp2() {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Teacher";
			ResultSet rs = in.executeQuery(sql);
			Teacher[] tea = new Teacher[100];
			int i = 0;
			while (rs.next()) {
				tea[i] = new Teacher();
				tea[i].Tno = rs.getString("Tno");
				tea[i].Tname = rs.getString("Tname");
				tea[i].Tage = rs.getInt("Tage");
				tea[i].Tsex = rs.getString("Tsex");
				if (i > 0) {
					tea[i - 1].flag = true;
				}
				++i;
			}
			in.close();
			return tea;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	Student[] search() {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Stu_Cla";
			ResultSet rs = in.executeQuery(sql);
			Student[] stu = new Student[100];
			String[] cn = new String[100];
			int[] grade = new int[100];
			int i = 0;
			while (rs.next()) {
				stu[i] = new Student();
				stu[i].Sno = rs.getString("Sno");
				cn[i] = rs.getString("Cno");
				grade[i] = rs.getInt("Grade");
				++i;
			}
			for (int j = 0; j < i; ++j) {
				stu[j] = searchstu(stu[j].Sno);
				stu[j].cn = cn[j];
				stu[j].grade = grade[j];
				if (j > 0) {
					stu[j - 1].flag = true;
				}
			}

			in.close();
			return stu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	Teacher[] searcht() {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Tea_Cla";
			ResultSet rs = in.executeQuery(sql);
			Teacher[] tea = new Teacher[100];
			String[] cn = new String[100];
			int i = 0;
			while (rs.next()) {
				tea[i] = new Teacher();
				tea[i].Tno = rs.getString("Tno");
				cn[i] = rs.getString("Cno");
				++i;
			}
			for (int j = 0; j < i; ++j) {
				tea[j] = searchteacher(tea[j].Tno);
				tea[j].cn = cn[j];
				if (j > 0) {
					tea[j - 1].flag = true;
				}
			}

			in.close();
			return tea;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	CClass[] searchclass() {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Class";
			ResultSet rs = in.executeQuery(sql);
			CClass[] classlist = new CClass[100];
			int i = 0;
			while (rs.next()) {
				classlist[i] = new CClass();
				classlist[i].Cno = rs.getString("Cno");
				classlist[i].Cname = rs.getString("Cname");
				if (i > 0) {
					classlist[i - 1].flag = true;
				}
				i++;
			}
			in.close();
			return classlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	Teacher searchteacherbyt(String Tno) {
		try {
			Statement in = conn.createStatement();
			String sql;
			ResultSet rs;
			Teacher tea = new Teacher();
			tea.Tno = Tno;
			sql = "select * from Teacher where Tno=" + "'" + Tno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				tea.Tname = rs.getString("Tname");
				tea.Tsex = rs.getString("Tsex");
				tea.Tage = rs.getInt("Tage");
			}
			sql = "select * from TeacherUser where Tno=" + "'" + tea.Tno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				tea.Tkey = rs.getString("Tkey");
			}
			sql = "select * from Tea_Cla where Tno=" + "'" + Tno + "'";
			rs = in.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				tea.Cno[i] = rs.getString("Cno");
				i++;
			}
			tea.classcnt = i;
			tea.Class = searchCname(tea.Cno, i);
			in.close();
			return tea;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	Teacher searchteacher(String Cno) {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Tea_Cla where Cno=" + "'" + Cno + "'";
			ResultSet rs = in.executeQuery(sql);
			Teacher tea = new Teacher();
			while (rs.next()) {
				tea.Tno = rs.getString("Tno");
			}
			sql = "select * from Teacher where Tno=" + "'" + tea.Tno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				tea.Tname = rs.getString("Tname");
				tea.Tsex = rs.getString("Tsex");
				tea.Tage = rs.getInt("Tage");
			}
			sql = "select * from TeacherUser where Tno=" + "'" + tea.Tno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				tea.Tkey = rs.getString("Tkey");
			}
			in.close();
			return tea;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	int searchGrade(String Sno, String Cno) {
		try {
			int grade = -1;
			Statement in = conn.createStatement();
			String sql;
			ResultSet rs;
			sql = "select * from Stu_Cla where Sno='" + Sno + "'and Cno=" + "'"
					+ Cno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				grade = rs.getInt("Grade");
			}
			return grade;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	String[] searchst(String Cno) {
		try {
			int grade = -1;
			Statement in = conn.createStatement();
			String sql;
			ResultSet rs;
			String[] ans = new String[100];
			sql = "select * from Stu_Cla where Cno=" + "'" + Cno + "'";
			rs = in.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				ans[i] = rs.getString("Sno");
				++i;
			}
			return ans;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	String[] searchCname(String[] Cno, int i) {
		try {
			String[] Class = new String[100];
			Statement in = conn.createStatement();
			String sql;
			ResultSet rs;
			for (int j = 0; j < i; ++j) {
				sql = "select * from Class where Cno=" + "'" + Cno[j] + "'";
				rs = in.executeQuery(sql);
				while (rs.next()) {
					Class[j] = rs.getString("Cname");
				}
			}
			return Class;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	Student searchstu(String Sno) {
		Student stu = new Student();
		try {
			Statement in = conn.createStatement();
			String sql = "select * from Student where Sno=" + "'" + Sno + "'";
			ResultSet rs = in.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				stu.Sname = rs.getString("Sname");
				stu.Sno = rs.getString("Sno");
				stu.Ssex = rs.getString("Ssex");
				stu.Sage = rs.getInt("Sage");
			}
			sql = "select * from StudentUser where Sno=" + "'" + Sno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				stu.Skey = rs.getString("Skey");
			}
			sql = "select * from Stu_Cla where Sno=" + "'" + Sno + "'";
			rs = in.executeQuery(sql);
			while (rs.next()) {
				stu.Cno[i] = rs.getString("Cno");
				i++;
			}
			stu.classcnt = i;
			stu.Class = searchCname(stu.Cno, i);
			in.close();
			return stu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	String searchkey(String Sno) {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from StudentUser where Sno=" + "'" + Sno
					+ "'";
			ResultSet rs = in.executeQuery(sql);
			while (rs.next()) {
				String key = rs.getString("Skey");
				return key;
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	String searchTkey(String Tno) {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from TeacherUser where Tno=" + "'" + Tno
					+ "'";
			ResultSet rs = in.executeQuery(sql);
			while (rs.next()) {
				String key = rs.getString("Tkey");
				return key;
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	String searchadminkey(String adminkey) {
		try {
			Statement in = conn.createStatement();
			String sql = "select * from AdminUser where adminkey=" + "'"
					+ adminkey + "'";
			ResultSet rs = in.executeQuery(sql);
			while (rs.next()) {
				String key = rs.getString("adminkey");
				return key;
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 修改
	void updatekey(String Sno, String newkey) {
		try {
			Statement in = conn.createStatement();
			String sql = "update StudentUser set Skey=" + "'" + newkey + "'"
					+ "where Sno=" + "'" + Sno + "'";
			int line = in.executeUpdate(sql);
			if (line != 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateTkey(String tno, String newkey) {
		try {
			Statement in = conn.createStatement();
			String sql = "update TeacherUser set Tkey=" + "'" + newkey + "'"
					+ "where Tno=" + "'" + tno + "'";
			int line = in.executeUpdate(sql);
			if (line != 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updatedaminkey(String admin, String k2) {
		try {
			Statement in = conn.createStatement();
			String sql = "update AdminUser set adminkey=" + "'" + k2 + "'"
					+ "where admin=" + "'" + admin + "'";
			int line = in.executeUpdate(sql);
			if (line != 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updategrade(String cno, String sno, int grades) {
		try {
			Statement in = conn.createStatement();
			String sql = "update Stu_Cla set Grade=" + "'" + grades + "'"
					+ "where Sno=" + "'" + sno + "' and Cno=" + "'" + cno + "'";
			int line = in.executeUpdate(sql);
			if (line != 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失敗");
			}
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭数据库连接
	void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
