package com.coderscampus.sri;

public class Main {
	// File name for the student master list CSV file
	public static String FILE_NAME = "student-master-list.csv";

	// List of course abbreviations to filter students by:
	public static String[] COURSES = { "COMPSCI", "APMTH", "STAT" };


	public static void main(String[] args) {
		StudentService service = new StudentService();

		// Parse the CSV File and create an array of Student objects:
		String[] lines = service.parseFile(FILE_NAME);
		Student[] studentList = service.makeUserList(lines);

		// Filter students by course, sort in descending order of grade, and export each group to a separate file
		int courseNumber = 1;
		for (String course : COURSES) {
			Student[] filteredByCourse = service.filterStudentsByCourse(course, studentList);
			Student[] sortedFilteredCourses = service.sortStudentsByDesc(filteredByCourse);
			service.exportToFile(sortedFilteredCourses, String.format("course%s.csv", courseNumber));
			courseNumber++;
		}
		System.out.println("Program Complete");
	}

}
