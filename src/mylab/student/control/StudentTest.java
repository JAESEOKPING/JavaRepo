package mylab.student.control;

import mylab.student.entity.Student;

public class StudentTest {
	public static void main(String[] args) {
		try {			
			Student a = new Student("1234567", "���缮", "��ǻ�Ͱ���", 3);
			a.setGrade(3);
			System.out.println(a.getName() + "/" + a.getMajor() + "/" + a.getGrade()+"�г�");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		try {			
			Student b = new Student("1234567", "�Źμ�", "�ż������", 5);
			b.setGrade(5);
			System.out.println(b.getName() + "/" + b.getMajor() + "/" + b.getGrade()+"�г�");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
