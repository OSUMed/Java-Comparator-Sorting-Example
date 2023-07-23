package com.coderscampus.sri;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private String course;
	private Integer grade;

	public Student(int id, String name, String course, Integer grade) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", grade=" + grade + "]";
	}

	// Arrays.sort needs Comparator but Student Object doesn't have it,
	// so we implement a Comparable:
	@Override
	public int compareTo(Student that) {
		// If grade is bigger, then we return -1, thus, appears before:
		if (this.grade > that.grade) {
			return -1;
			// If grade is smaller, then we return 1, thus, appears after:
		} else if (this.grade < that.grade) {
			return 1;
		}
		// If grade is equal, we use String Comparator to compare:
		return this.name.compareTo(that.name);

	}
}
