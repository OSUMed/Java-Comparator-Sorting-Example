package com.coderscampus.sri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentService {

	/**
	 * Filters the array of Student objects with the given course.
	 *
	 * @param course      The course to be used as a filter.
	 * @param studentList An array of Student objects to be filtered.
	 * @return An array of Student objects that match the given course.
	 */
	public Student[] filterStudentsByCourse(String course, Student[] studentList) {
		
		// Create an array to store students with the matching course name
		Student[] filteredStudents = new Student[100];
		int i = 0;
		
		// Get course name abbreviation from full course name, then filter students that match 
		for (Student student : studentList) {
			String[] fullStudentCourse = student.getCourse().split(" ");
			String studentCourseAbbr = fullStudentCourse[0];
			if (studentCourseAbbr.equals(course)) {
				filteredStudents[i] = student;
				i++;
			}
		}
		
		// Count students that match the course name to determine the new array size
		int studentCounter = 0;
		for (Student s : filteredStudents) {
		    if (s != null) {
		        studentCounter++;
		    }
		}

		// Create a new array with filtered students (without null values)
		Student[] cleanFilteredStudents = new Student[studentCounter];
		for (int index = 0; index < studentCounter; index++) {
		    cleanFilteredStudents[index] = filteredStudents[index];
		}

		// Return the new array
		return cleanFilteredStudents;
	}

	/**
	 * Sorts the array of Student objects in descending order of their grade.
	 *
	 * @param studentList An array of Student objects to be sorted.
	 * @return A sorted array of Student objects in descending order of their grade.
	 */
	public Student[] sortStudentsByDesc(Student[] studentList) {
	    Arrays.sort(studentList);
	    return studentList;
	}


	/**
	 * Exports a list of Student objects to a file in CSV format.
	 *
	 * @param studentList  An array of Student objects to be exported.
	 * @param fileName     The name of the file to be written in.
	 * @throws IOException If an I/O error occurs while writing to the file.
	 */
	public void exportToFile(Student[] studentList, String fileName) {
		
		// Initialize writer to null so it can be accessed after try block:
		BufferedWriter writer = null;
		
		// Write Headers and then each line:
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("Student ID,Student Name,Course,Grade\n");
			for (Student student : studentList) {
				if (student == null) {
					continue;
				}
				
				// Create line to be written, and then write it to the file:
				String writeToFile = String.format("%d, %s, %s, %d\n", student.getId(), student.getName(),
						student.getCourse(), student.getGrade());
				writer.write(writeToFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Creates an array of Student objects from the input lines containing student information.
	 *
	 * @param lines An array of strings, each representing a line of student information
	 *              in the format "id,name,course,grade".
	 * @return An array of Student objects containing the parsed student information.
	 */
	public Student[] makeUserList(String[] lines) {
		Student[] studentList = new Student[100];
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
			studentList[i] = newStudent;
			i++;
		}
		return studentList;
	}

	/**
	 * Reads the contents of the specified file and returns them as an array of strings.
	 *
	 * @param fileName The name of the file to be parsed.
	 * @return An array of strings, each representing a line of student information
	 *         read from the file, excluding the first line (header).
	 * @throws FileNotFoundException If the specified file is not found.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public String[] parseFile(String fileName) {
		
		// Initialize reader to null so it can be accessed after try block:
		BufferedReader reader = null;
		
		// Open the file:
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		
		// Read the file:
		String[] lines = new String[102];
		int i = 0;
		String line = null;
		Boolean firstLine = true;
		try {
			
			// Skip the first header line, store each line in the array:
			while ((line = reader.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					i++;
					continue;
				}
				lines[i] = line;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lines;
	}
}
