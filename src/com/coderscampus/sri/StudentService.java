package com.coderscampus.sri;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentService {
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
