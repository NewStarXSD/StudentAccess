package zxg2013329700013.access;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Login log = new Login();
		log.setVisible(true);

		/*JDBC Stu = new JDBC();
		System.out.println("�������û����ͣ�");
		System.out.println("1.ѧ��");
		System.out.println("2.��ʦ");
		System.out.println("3.����Ա");
		Scanner in = new Scanner(System.in);
		int op = in.nextInt();
		while (op != 1 && op != 2 && op != 3) {
			System.out.println("���������������������ͣ�");
			op = in.nextInt();
		}
		if (op == 1) {
			CClass[] classlist = Stu.searchclass();
			Student stu = new Student();
			System.out.println("������ѧ��");
			String stuno = in.next();
			String itemkey = Stu.searchkey(stuno);
			if (itemkey == null) {
				System.out.println("�û���������");
			} else {
				System.out.println("����������");
				String stkey = in.next();
				while (!stkey.equals(itemkey)) {
					System.out.println("�������");
					stkey = in.next();
				}
				System.out.println("��½�ɹ�");
				while (true) {
					stu = Stu.searchstu(stuno);
					int sop;
					System.out.println("���������");
					System.out.println("1.��ѯ��ѡ�γ�");
					System.out.println("2.��ѯ����");
					System.out.println("3.��ʾ������Ϣ");
					System.out.println("4.�޸�����");
					System.out.println("5.��ѯ��ѡ�γ̱�ŵ���ʦ");
					System.out.println("6.ѡ��");
					System.out.println("7.��ѯ�ɼ�");
					System.out.println("8.�˳�");
					sop = in.nextInt();
					if (sop == 1) {
						for (int i = 0; i < stu.classcnt; ++i) {
							System.out.println("�γ�" + (i + 1) + "��"
									+ stu.Class[i]);
						}
					} else if (sop == 2) {
						System.out.println(stu.Skey);
					} else if (sop == 3) {
						System.out.println("������" + stu.Sname);
						System.out.println("ѧ�ţ�" + stu.Sno);
						System.out.println("�Ա�" + stu.Ssex);
						System.out.println("���䣺" + stu.Sage);
					} else if (sop == 4) {
						System.out.println("������������");
						String newkey = in.next();
						Stu.updatekey(stu.Sno, newkey);
					} else if (sop == 5) {
						System.out.println("������γ̱��");
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
						System.out.println("��������ѡ��Ŀγ̱��");
						String Cno = in.next();
						Stu.insertSC(stu.Sno, Cno);
					} else if (sop == 7) {
						System.out.println("���������ѯ�Ŀγ̱��");
						String Cno = in.next();
						int grade = Stu.searchGrade(stu.Sno, Cno);
						if (grade == -1) {
							System.out.println("δ�гɼ���δѡ��ÿ�");
						} else {
							System.out.println("���ſεĳɼ�Ϊ��" + grade);
						}
					} else if (sop == 8) {
						Stu.close();
						System.out.println("�ɹ��˳�");
						break;
					}
				}
			}
		} else if (op == 2) {
			Teacher tea = new Teacher();
			System.out.println("������̹���");
			tea.Tno = in.next();
			String itemkey = Stu.searchTkey(tea.Tno);
			if (itemkey == null) {
				System.out.println("�û���������");
			} else {
				System.out.println("����������");
				String tkey = in.next();
				while (!tkey.equals(itemkey)) {
					System.out.println("�������");
					tkey = in.next();
				}
				System.out.println("��½�ɹ�");
				while (true) {
					tea = Stu.searchteacherbyt(tea.Tno);
					int top;
					System.out.println("���������");
					System.out.println("1.��ѯ���̿γ�");
					System.out.println("2.��ѯ����");
					System.out.println("3.��ʾ������Ϣ");
					System.out.println("4.�޸�����");
					System.out.println("5.��ѯ���̿γ�ѧ������");
					System.out.println("6.�Ǽǳɼ�");
					System.out.println("7.�˳�");
					top = in.nextInt();
					if (top == 1) {
						for (int i = 0; i < tea.classcnt; ++i) {
							System.out.println("�γ�" + (i + 1) + "��"
									+ tea.Class[i]);
						}
					} else if (top == 2) {
						System.out.println(tea.Tkey);
					} else if (top == 3) {
						System.out.println("������" + tea.Tname);
						System.out.println("�̹��ţ�" + tea.Tno);
						System.out.println("�Ա�" + tea.Tsex);
						System.out.println("���䣺" + tea.Tage);
					} else if (top == 4) {
						System.out.println("������������");
						String newkey = in.next();
						Stu.updateTkey(tea.Tno, newkey);
					} else if (top == 5) {
						System.out.println("������γ̱��");
						String Cno = in.next();
						boolean flag = false;
						for (int i = 0; i < tea.classcnt; ++i) {
							if (Cno.equals(tea.Cno[i])) {
								flag = true;
							}
						}
						if (!flag) {
							System.out.println("��û�����ſ�");
							continue;
						}
						String[] student = new String[100];
						student = Stu.searchst(Cno);
						for (int i = 0; student[i] != null; ++i) {
							Student stu = Stu.searchstu(student[i]);
							System.out.println("����\tѧ��");
							System.out.println(stu.Sname + "\t" + student[i]);
						}
					} else if (top == 6) {
						boolean flag = false;
						System.out.println("������γ̱��");
						String cno = in.next();
						for (int i = 0; i < tea.classcnt; ++i) {
							if (cno.equals(tea.Cno[i])) {
								flag = true;
							}
						}
						if (!flag) {
							System.out.println("��û�����ſ�");
							continue;
						}
						System.out.println("������ѧ����");
						String sno = in.next();
						System.out.println("������ɼ�");
						int grades = in.nextInt();
						Stu.updategrade(cno, sno, grades);
					} else if (top == 7) {
						Stu.close();
						System.out.println("�ɹ��˳�");
						break;
					}
				}
			}
		} else if (op == 3) {
			Admin adm = new Admin();
			System.out.println("�������û���");
			adm.admin = in.next();
			String itemkey = Stu.searchadminkey(adm.admin);
			if (itemkey == null) {
				System.out.println("�û���������");
			} else {
				System.out.println("����������");
				String adminkey = in.next();
				while (!adminkey.equals(itemkey)) {
					System.out.println("�������");
					adminkey = in.next();
				}
				System.out.println("��½�ɹ�");
				while (true) {
					int top;
					System.out.println("���������");
					System.out.println("1.����ѧ���û�");
					System.out.println("2.ɾ��ѧ���û�");
					System.out.println("3.���ӽ�ʦ�û�");
					System.out.println("4.ɾ����ʦ�û�");
					System.out.println("5.���ӿγ�");
					System.out.println("6.ɾ���γ�");
					System.out.println("7.�˿�");
					System.out.println("8.�˳�");
					top = in.nextInt();
					if (top == 1) {
						System.out.println("������ѧ��");
						String Sno = in.next();
						System.out.println("������ѧ������");
						String Sname = in.next();
						System.out.println("������ѧ���Ա�");
						String Ssex = in.next();
						System.out.println("������ѧ������");
						int Sage = in.nextInt();
						System.out.println("ѧ����ʼ����Ϊ��123456");
						Stu.insertStu(Sno, Sname, Ssex, Sage, "123456");
					} else if (top == 2) {
						System.out.println("������ѧ��");
						String Sno = in.next();
						Stu.deleteStu(Sno);
					} else if (top == 3) {
						System.out.println("������̹���");
						String Tno = in.next();
						System.out.println("�������ʦ����");
						String Tname = in.next();
						System.out.println("�������ʦ�Ա�");
						String Tsex = in.next();
						System.out.println("�������ʦ����");
						int Tage = in.nextInt();
						System.out.println("��ʦ��ʼ����Ϊ��123456");
						Stu.insertTea(Tno, Tname, Tsex, Tage, "123456");
					} else if (top == 4) {
						System.out.println("������̹���");
						String Tno = in.next();
						Stu.deleteTea(Tno);
					} else if (top == 5) {
						System.out.println("������γ̱��");
						String Cno = in.next();
						System.out.println("������γ���");
						String Cname = in.next();
						System.out.println("�������ον�ʦ�̹���");
						String Tno = in.next();
						Stu.insertClass(Cno, Cname, Tno);
					} else if (top == 6) {
						System.out.println("������γ̱��");
						String Cno = in.next();
						Stu.deleteClass(Cno);
					} else if (top == 7) {
						System.out.println("������ѧ��");
						String Sno = in.next();
						System.out.println("������γ̱��");
						String Cno = in.next();
						Stu.delete(Sno, Cno);
					} else if (top == 8) {
						Stu.close();
						System.out.println("�ɹ��˳�");
						break;
					}
				}
			}
		}*/
	}
}
