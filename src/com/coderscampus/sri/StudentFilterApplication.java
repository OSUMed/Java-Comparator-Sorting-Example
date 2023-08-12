package com.coderscampus.sri;

public class StudentFilterApplication {

	// List of course abbreviations to filter students by:
	public static String[] COURSES = { "COMPSCI", "APMTH", "STAT" };


	public static void main(String[] args) {
		
		StudentService service = new StudentService();


		// Filter students by course, sort in descending order of grade, and export each group to a separate file
		int courseNumber = 1;
		for (String course : COURSES) {
			Student[] filteredByCourse = service.filterStudentsByCourse(course);
			service.saveStudents(filteredByCourse, String.format("course%s.csv", courseNumber));
			courseNumber++;
		}
		System.out.println("Program Complete");
	}

}
