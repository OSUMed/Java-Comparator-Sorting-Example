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
		String[] lines = service.parseFile(FILE_NAME);
		System.out.println(lines);
	}

}
