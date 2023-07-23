package com.coderscampus.sri;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentService {
	
	public Student[] filterStudentsByCourse(String course, Student[] studentList) {
		Student[] filteredStudents = new Student[100];
		int i = 0;
		for (Student student: studentList) {
			String[] fullStudentCourse = student.getCourse().split(" ");
			String studentCourse = fullStudentCourse[0];
			if (studentCourse.equals(course)) {
				filteredStudents[i] = student;
				i++;
			}
		}
//		for (Student s: filteredStudents) {
//			System.out.println(s);
//		}
//		System.out.println("Done: ");
		int studentCounter = 0;
		for (Student s: filteredStudents) {
			if (s != null) {
				studentCounter += 1;
			}
		}
		Student[] cleanFilteredStudents = new Student[studentCounter];
		for (int index=0; index<studentCounter ; index++) {
			cleanFilteredStudents[index] = filteredStudents[index];

		}
//		for (Student s: cleanFilteredStudents) {
//			System.out.println(s);
//		}
		return cleanFilteredStudents;
	}
	public Student[] sortStudentsByDesc(Student[] studentList){
		Arrays.sort(studentList);
		return studentList;
	}
	public void exportToFile(Student[] studentList, String fileName) {
		BufferedWriter writer = null;
		// Write Headers and then lines:
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("Student ID,Student Name,Course,Grade\n");
			for (Student student: studentList) {
				if (student == null) {
					continue;
				}
				String writeToFile = String.format("%d, %s, %s, %d\n", student.getId(), student.getName(), student.getCourse(), student.getGrade());
				writer.write(writeToFile);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static Student[] makeUserList(String[] lines) {
		Student[] studentList = new Student[100];
		int i = 0;
		for (String line: lines) {
			if (line == null) {
				continue;
			}
			String[] studentProperties = line.split(",");
			int id = Integer.parseInt(studentProperties[0]);
			String name = studentProperties[1];
			String course = studentProperties[2];
			int grade = Integer.parseInt(studentProperties[3]);
			Student newStudent = new Student(id, name, course, grade);
			studentList[i] = newStudent;
			i++;
		}
//		for (Student s: studentList) {
//			System.out.println(s);
//		}
		return studentList;
	}
	public static String[] parseFile(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		String[] lines = new String[102];
		int i = 0;
		String line = null;
		Boolean firstLine = true;
		try {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		for (String l: lines) {
//			System.out.println(l);
//		}
		return lines;
	}
}
