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
			throw new InvalidGradeException("학년은 1~4사이여야 합니다.");
		}else {	
			this.grade = grade;
		}
	}
	
}

//Student 클래스를 작성하고, 다음 조건을 만족하도록 캡슐화(Encapsulation)를 적용하시오.
//필드: 학번(studentId), 이름(name), 전공(major), 학년(grade) → 모두 private
//모든 필드에 대해 getter와 setter 작성
//학년은 1~4 까지만 허용되며, 범위를 벗어날 경우 오류 메시지를 출력하도록 setGrade() 구현
