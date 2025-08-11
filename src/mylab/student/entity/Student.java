package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	// default Constructor
	public Student() {
		
	}
	
	public Student(String studentId, String name, String major, int grade) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}

	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setGrade(int grade) throws Exception{
		if(grade < 1 || grade > 4) {			
			throw new InvalidGradeException("�г��� 1~4���̿��� �մϴ�.");
		}else {	
			this.grade = grade;
		}
	}
	
}

//Student Ŭ������ �ۼ��ϰ�, ���� ������ �����ϵ��� ĸ��ȭ(Encapsulation)�� �����Ͻÿ�.
//�ʵ�: �й�(studentId), �̸�(name), ����(major), �г�(grade) �� ��� private
//��� �ʵ忡 ���� getter�� setter �ۼ�
//�г��� 1~4 ������ ���Ǹ�, ������ ��� ��� ���� �޽����� ����ϵ��� setGrade() ����
