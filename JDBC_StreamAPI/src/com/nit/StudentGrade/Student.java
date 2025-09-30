package com.nit.StudentGrade;

public class Student {
	private int id;
	private String name;
	private int grade;
	private String course;
	public Student(int id, String name, int grade, String course) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", course=" + course + "]";
	}
	
	
	
}
