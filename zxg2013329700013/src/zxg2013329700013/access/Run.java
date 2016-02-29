package zxg2013329700013.access;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Login log = new Login();
		log.setVisible(true);

		/*JDBC Stu = new JDBC();
		System.out.println("请输入用户类型：");
		System.out.println("1.学生");
		System.out.println("2.教师");
		System.out.println("3.管理员");
		Scanner in = new Scanner(System.in);
		int op = in.nextInt();
		while (op != 1 && op != 2 && op != 3) {
			System.out.println("操作错误，请重新输入类型：");
			op = in.nextInt();
		}
		if (op == 1) {
			CClass[] classlist = Stu.searchclass();
			Student stu = new Student();
			System.out.println("请输入学号");
			String stuno = in.next();
			String itemkey = Stu.searchkey(stuno);
			if (itemkey == null) {
				System.out.println("用户名不存在");
			} else {
				System.out.println("请输入密码");
				String stkey = in.next();
				while (!stkey.equals(itemkey)) {
					System.out.println("密码错误");
					stkey = in.next();
				}
				System.out.println("登陆成功");
				while (true) {
					stu = Stu.searchstu(stuno);
					int sop;
					System.out.println("请输入操作");
					System.out.println("1.查询所选课程");
					System.out.println("2.查询密码");
					System.out.println("3.显示个人信息");
					System.out.println("4.修改密码");
					System.out.println("5.查询所选课程编号的老师");
					System.out.println("6.选课");
					System.out.println("7.查询成绩");
					System.out.println("8.退出");
					sop = in.nextInt();
					if (sop == 1) {
						for (int i = 0; i < stu.classcnt; ++i) {
							System.out.println("课程" + (i + 1) + "："
									+ stu.Class[i]);
						}
					} else if (sop == 2) {
						System.out.println(stu.Skey);
					} else if (sop == 3) {
						System.out.println("姓名：" + stu.Sname);
						System.out.println("学号：" + stu.Sno);
						System.out.println("性别：" + stu.Ssex);
						System.out.println("年龄：" + stu.Sage);
					} else if (sop == 4) {
						System.out.println("请输入新密码");
						String newkey = in.next();
						Stu.updatekey(stu.Sno, newkey);
					} else if (sop == 5) {
						System.out.println("请输入课程编号");
						String Cno = in.next();
						Teacher tea = Stu.searchteacher(Cno);
						System.out.println(tea.Tname);
					} else if (sop == 6) {
						int i = 0;
						while (classlist[i].flag) {
							System.out.println(classlist[i].Cno + "\t"
									+ classlist[i].Cname);
							i++;
						}
						System.out.println(classlist[i].Cno + "\t"
								+ classlist[i].Cname);
						System.out.println("请输入想选择的课程编号");
						String Cno = in.next();
						Stu.insertSC(stu.Sno, Cno);
					} else if (sop == 7) {
						System.out.println("请输入想查询的课程编号");
						String Cno = in.next();
						int grade = Stu.searchGrade(stu.Sno, Cno);
						if (grade == -1) {
							System.out.println("未有成绩或未选择该课");
						} else {
							System.out.println("本门课的成绩为：" + grade);
						}
					} else if (sop == 8) {
						Stu.close();
						System.out.println("成功退出");
						break;
					}
				}
			}
		} else if (op == 2) {
			Teacher tea = new Teacher();
			System.out.println("请输入教工号");
			tea.Tno = in.next();
			String itemkey = Stu.searchTkey(tea.Tno);
			if (itemkey == null) {
				System.out.println("用户名不存在");
			} else {
				System.out.println("请输入密码");
				String tkey = in.next();
				while (!tkey.equals(itemkey)) {
					System.out.println("密码错误");
					tkey = in.next();
				}
				System.out.println("登陆成功");
				while (true) {
					tea = Stu.searchteacherbyt(tea.Tno);
					int top;
					System.out.println("请输入操作");
					System.out.println("1.查询所教课程");
					System.out.println("2.查询密码");
					System.out.println("3.显示个人信息");
					System.out.println("4.修改密码");
					System.out.println("5.查询所教课程学生名单");
					System.out.println("6.登记成绩");
					System.out.println("7.退出");
					top = in.nextInt();
					if (top == 1) {
						for (int i = 0; i < tea.classcnt; ++i) {
							System.out.println("课程" + (i + 1) + "："
									+ tea.Class[i]);
						}
					} else if (top == 2) {
						System.out.println(tea.Tkey);
					} else if (top == 3) {
						System.out.println("姓名：" + tea.Tname);
						System.out.println("教工号：" + tea.Tno);
						System.out.println("性别：" + tea.Tsex);
						System.out.println("年龄：" + tea.Tage);
					} else if (top == 4) {
						System.out.println("请输入新密码");
						String newkey = in.next();
						Stu.updateTkey(tea.Tno, newkey);
					} else if (top == 5) {
						System.out.println("请输入课程编号");
						String Cno = in.next();
						boolean flag = false;
						for (int i = 0; i < tea.classcnt; ++i) {
							if (Cno.equals(tea.Cno[i])) {
								flag = true;
							}
						}
						if (!flag) {
							System.out.println("您没有这门课");
							continue;
						}
						String[] student = new String[100];
						student = Stu.searchst(Cno);
						for (int i = 0; student[i] != null; ++i) {
							Student stu = Stu.searchstu(student[i]);
							System.out.println("姓名\t学号");
							System.out.println(stu.Sname + "\t" + student[i]);
						}
					} else if (top == 6) {
						boolean flag = false;
						System.out.println("请输入课程编号");
						String cno = in.next();
						for (int i = 0; i < tea.classcnt; ++i) {
							if (cno.equals(tea.Cno[i])) {
								flag = true;
							}
						}
						if (!flag) {
							System.out.println("您没有这门课");
							continue;
						}
						System.out.println("请输入学生号");
						String sno = in.next();
						System.out.println("请输入成绩");
						int grades = in.nextInt();
						Stu.updategrade(cno, sno, grades);
					} else if (top == 7) {
						Stu.close();
						System.out.println("成功退出");
						break;
					}
				}
			}
		} else if (op == 3) {
			Admin adm = new Admin();
			System.out.println("请输入用户名");
			adm.admin = in.next();
			String itemkey = Stu.searchadminkey(adm.admin);
			if (itemkey == null) {
				System.out.println("用户名不存在");
			} else {
				System.out.println("请输入密码");
				String adminkey = in.next();
				while (!adminkey.equals(itemkey)) {
					System.out.println("密码错误");
					adminkey = in.next();
				}
				System.out.println("登陆成功");
				while (true) {
					int top;
					System.out.println("请输入操作");
					System.out.println("1.增加学生用户");
					System.out.println("2.删除学生用户");
					System.out.println("3.增加教师用户");
					System.out.println("4.删除教师用户");
					System.out.println("5.增加课程");
					System.out.println("6.删除课程");
					System.out.println("7.退课");
					System.out.println("8.退出");
					top = in.nextInt();
					if (top == 1) {
						System.out.println("请输入学号");
						String Sno = in.next();
						System.out.println("请输入学生姓名");
						String Sname = in.next();
						System.out.println("请输入学生性别");
						String Ssex = in.next();
						System.out.println("请输入学生年龄");
						int Sage = in.nextInt();
						System.out.println("学生初始密码为：123456");
						Stu.insertStu(Sno, Sname, Ssex, Sage, "123456");
					} else if (top == 2) {
						System.out.println("请输入学号");
						String Sno = in.next();
						Stu.deleteStu(Sno);
					} else if (top == 3) {
						System.out.println("请输入教工号");
						String Tno = in.next();
						System.out.println("请输入教师姓名");
						String Tname = in.next();
						System.out.println("请输入教师性别");
						String Tsex = in.next();
						System.out.println("请输入教师年龄");
						int Tage = in.nextInt();
						System.out.println("教师初始密码为：123456");
						Stu.insertTea(Tno, Tname, Tsex, Tage, "123456");
					} else if (top == 4) {
						System.out.println("请输入教工号");
						String Tno = in.next();
						Stu.deleteTea(Tno);
					} else if (top == 5) {
						System.out.println("请输入课程编号");
						String Cno = in.next();
						System.out.println("请输入课程名");
						String Cname = in.next();
						System.out.println("请输入任课教师教工号");
						String Tno = in.next();
						Stu.insertClass(Cno, Cname, Tno);
					} else if (top == 6) {
						System.out.println("请输入课程编号");
						String Cno = in.next();
						Stu.deleteClass(Cno);
					} else if (top == 7) {
						System.out.println("请输入学号");
						String Sno = in.next();
						System.out.println("请输入课程编号");
						String Cno = in.next();
						Stu.delete(Sno, Cno);
					} else if (top == 8) {
						Stu.close();
						System.out.println("成功退出");
						break;
					}
				}
			}
		}*/
	}
}
