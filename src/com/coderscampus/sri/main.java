package com.coderscampus.sri;

public class main {
	public static String FILE_NAME = "student-master-list.csv";
	public static String[] COURSES = { "COMPSCI", "APMTH", "STAT" };

	public static void main(String[] args) {
		// Make Service:
		StudentService service = new StudentService();

		// Parse File using service:
		String[] lines = service.parseFile(FILE_NAME);

		// Make user object list using service:
		Student[] studentList = service.makeUserList(lines);

		// Call service to filter Students by course and export each filtered group to
		// file:
		Student[] filteredByCourse = null;
		Student[] sortedFilteredCourses = null;
		int number = 1;
		for (String course : COURSES) {
			// Filter Students by course:
			filteredByCourse = service.filterStudentsByCourse(course, studentList);

			// Sort filtered students by DESC order:
			sortedFilteredCourses = service.sortStudentsByDesc(filteredByCourse);

			// Export filtered courses to file:
			service.exportToFile(sortedFilteredCourses, String.format("course%s.csv", number));
			number++;
		}
		System.out.println("Program Complete");
	}

}
