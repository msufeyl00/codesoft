import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private static final String FILENAME = "students.txt";

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        loadStudentsFromFile(); // Load students when the system is initialized
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
        saveStudentsToFile();
    }

    public boolean removeStudent(String rollNumber) {
        Iterator<Student> iterator = students.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber().equals(rollNumber)) {
                iterator.remove();
                System.out.println("Student with roll number " + rollNumber + " removed.");
                removed = true;
                break;
            }
        }
        if (removed) {
            saveStudentsToFile();
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
        return removed;
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        System.out.println("\n--- All Students ---");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("--------------------");
    }

    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                writer.newLine();
            }
            System.out.println("Student data saved to " + FILENAME);
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }

    private void loadStudentsFromFile() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("No existing student data file found. Starting with an empty system.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[0], parts[1], parts[2]));
                }
            }
            System.out.println("Student data loaded from " + FILENAME);
        } catch (IOException e) {
            System.err.println("Error loading student data: " + e.getMessage());
        }
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void setAllStudents(ArrayList<Student> students) {
        this.students = students;
    }
}

