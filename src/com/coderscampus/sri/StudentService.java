package com.coderscampus.sri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentService {

	private FileService fileService;
	Student[] students = new Student[100];
	public static String FILE_NAME = "student-master-list.csv";

	public StudentService() {
		fileService = new FileService();
		String[] data = fileService.parseFile(FILE_NAME);
		loadStudents(data);
		sortStudentsByDesc();

	}

	/**
	 * Sorts the array of Student objects in descending order of their grade.
	 *
	 * @return A sorted array of Student objects in descending order of their grade.
	 */
	public Student[] sortStudentsByDesc() {
		Arrays.sort(students);
		return students;
	}

	/**
	 * Creates an array of Student objects from the input lines containing student
	 * information.
	 *
	 * @param lines An array of strings, each representing a line of student
	 *              information in the format "id,name,course,grade".
	 */
	public void loadStudents(String[] lines) {
		int i = 0;

		// Iterate through each line:
		for (String line : lines) {
			if (line == null) {
				continue;
			}

			// Split the line into its individual elements:
			String[] studentProperties = line.split(",");
			int id = Integer.parseInt(studentProperties[0]);
			String name = studentProperties[1];
			String course = studentProperties[2];
			int grade = Integer.parseInt(studentProperties[3]);

			// Create a new Student object:
			Student newStudent = new Student(id, name, course, grade);

			// Add the new Student object to the Student array:
			students[i] = newStudent;
			i++;
		}
	}

	/**
	 * Filters the array of Student objects with the given course.
	 *
	 * @param course      The course to be used as a filter.
	 * @return An array of sorted Student objects that match the given course.
	 */
	public Student[] filterStudentsByCourse(String course) {

		// Create an array to store students with the matching course name
		Student[] filteredStudents = new Student[100];
		int i = 0;

		// Get course name abbreviation from full course name, then filter students that
		// match
		for (Student student : students) {
			String[] fullStudentCourse = student.getCourse().split(" ");
			String studentCourseAbbr = fullStudentCourse[0];
			if (studentCourseAbbr.equals(course)) {
				filteredStudents[i] = student;
				i++;
			}
		}

		// Return the new array
		return filteredStudents;
	}
	
	/**
	 * Calls file service to write data into file
	 *
	 * @param students    The sorted and filtered student object array that needs to be written to file
	 * @param filename    The name of the file the student objects need to be written in
	 */
	public void saveStudents(Student[] students, String filename) {
		fileService.exportToFile(students, filename);
	}

}
