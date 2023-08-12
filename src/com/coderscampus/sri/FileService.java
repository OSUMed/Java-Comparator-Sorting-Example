package com.coderscampus.sri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
	/**
	 * Reads the contents of the specified file and returns them as an array of
	 * strings.
	 *
	 * @param fileName The name of the file to be parsed.
	 * @return An array of strings, each representing a line of student information
	 *         read from the file, excluding the first line (header).
	 * @throws FileNotFoundException If the specified file is not found.
	 * @throws IOException           If an I/O error occurs while reading the file.
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

	/**
	 * Exports a list of Student objects to a file in CSV format.
	 *
	 * @param studentList An array of Student objects to be exported.
	 * @param fileName    The name of the file to be written in.
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
					break;
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
}
