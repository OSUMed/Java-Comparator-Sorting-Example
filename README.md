# sri-assignment-4

# College Data Management - Student Enrollment List Parser

## Description

As a Data Scientist at a College, your job is to help Professors manage the data they receive from the College. This project aims to assist Professors of three different classes with their student enrollment lists. The Professors were given a single CSV file containing a "master list" of all students across all courses. Your task is to parse the Master List File, separate the data into three separate CSV files, and sort the students by grade in descending order for each course.

## Requirements

To run this project, you'll need the following:

1. Java Development Kit (JDK) 8 or above installed on your system.
2. The input CSV file "student-master-list.csv" containing the master list of all students across all courses.

## Project Structure

The project directory contains the following files and directories:

- `.settings`: Contains project-specific settings for the IDE (e.g., Eclipse, IntelliJ).
- `src`: Contains the Java source code files.
  - `Student.java`: Represents the Student class with attributes like id, name, course, and grade.
  - `StudentService.java`: Implements methods to parse the input CSV, filter students by course, sort students by grade, and export to CSV files.
  - `Main.java`: The main Java program that initializes and utilizes the StudentService to perform the required tasks.
- `student-master-list.csv`: The input CSV file containing the master list of all students across all courses.
- `.gitignore`: Specifies the files and directories to be ignored by Git version control.

## Instructions

1. Clone this repository to your local machine:

   ```
   git clone https://github.com/OSUMed/sri-assignment-4.git
   ```

2. Place the input CSV file "student-master-list.csv" in the project root directory.

3. Compile and run the Java program:

   ```
   cd sri-assignment-4/src
   javac Main.java
   java Main
   ```

4. The program will generate three CSV output files: "course1.csv", "course2.csv", and "course3.csv", each containing a list of students specific to that particular course, sorted by grade in descending order.

## Notes

- The program assumes that the input CSV file follows a specific format, i.e., "id,name,course,grade".
- For any questions or issues, please contact [srikanthsmedicherla@gmail.com](mailto:srikanthsmedicherla@gmail.com).
