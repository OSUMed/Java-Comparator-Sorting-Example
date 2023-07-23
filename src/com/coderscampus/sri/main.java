package com.coderscampus.sri;

public class main {
	public static String FILE_NAME = "student-master-list.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		Student student = new Student(1, "Bob", "Spanish", 88);
		System.out.println(student);
		
		// Make Service:
		StudentService service = new StudentService();
		
		// Parse File using service:
		String[] lines = service.parseFile(FILE_NAME);
		
		// Make user object list using service:
		Student[] users = service.makeUserList(lines);
		
		// Call service to filter Students by course and export each filtered group to file:
		String[] courses = {"COMPSCI", "APMTH", "STAT"};
		Student[] filteredByCourse = null;
		Student[] sortedFilteredCourses = null;
		int number = 1;
		for (String course : courses) {
			// Filter Students by course:
			filteredByCourse = service.filterStudentsByCourse(course, lines);
			
//			// Sort filtered students by DESC order:
//			sortedFilteredCourses = service.sortStudentsByDesc(filteredByCourse);
			
			// Export filtered courses to file:
			service.exportToFile(filteredByCourse, String.format("course%s.csv", number));
			number++;
		}
		System.out.println("Program Complete");		
	}

}
