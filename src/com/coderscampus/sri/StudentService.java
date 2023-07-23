package com.coderscampus.sri;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentService {
	
	public static Student[] filterStudentsByCourse(Student[] studentList, String course) {
		Student[] filteredStudents
	}
	public static Student[] sortStudentsByDesc(Student[] studentList) {
		
	}
	public static void exportToFile(Student[] studentList) {
		
	}
	public static Student[] makeUserList(String[] lines) {
		Student[] studentList = new Student[101];
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
		for (Student s: studentList) {
			System.out.println(s);
		}
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
		for (String l: lines) {
			System.out.println(l);
		}
		return lines;
	}
}
