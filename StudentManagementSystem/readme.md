# Student Management System in Java

This project implements a console-based Student Management System in Java. It allows users to add, remove, search for, and display student records. Student data is persisted to a file.

## Project Structure

- `Student.java`: Represents a single student with attributes like name, roll number, and grade.
- `StudentManagementSystem.java`: Manages a collection of `Student` objects, providing methods for adding, removing, searching, and displaying students. It also handles saving and loading student data to/from `students.txt`.
- `Main.java`: The main class that provides the command-line interface for the Student Management System, handling user input and displaying output.

## How to Compile and Run

To compile and run this Java Student Management System, follow these steps:

1.  **Save the files:** Ensure you have `Student.java`, `StudentManagementSystem.java`, and `Main.java` in the same directory.

2.  **Open a terminal or command prompt:** Navigate to the directory where you saved the files.

3.  **Compile the Java files:** Use the Java compiler (`javac`) to compile all the `.java` files. If you don't have Java installed, please install OpenJDK 17 or a compatible version.

    ```bash
    javac Student.java StudentManagementSystem.java Main.java
    ```

4.  **Run the Student Management System:** After successful compilation, you can run the `Main` class using the Java Virtual Machine (`java`).

    ```bash
    java Main
    ```

## Usage

Once the program is running, you will see a menu with the following options:

1.  **Add Student:** Prompts for student's name, roll number, and grade, then adds the student to the system.
2.  **Remove Student:** Prompts for a student's roll number and removes the corresponding student from the system.
3.  **Search Student:** Prompts for a student's roll number and displays the student's details if found.
4.  **Display All Students:** Lists all students currently in the system.
5.  **Exit:** Exits the application. Student data is automatically saved when changes are made and loaded when the application starts.

