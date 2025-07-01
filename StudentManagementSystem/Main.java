import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addStudent(scanner, sms);
                    break;
                case 2:
                    removeStudent(scanner, sms);
                    break;
                case 3:
                    searchStudent(scanner, sms);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
            System.out.print("Enter your choice: ");
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return input;
    }

    private static String getStringInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.println("\n--- Add New Student ---");
        String name = getStringInput(scanner, "Enter student name: ");
        String rollNumber = getStringInput(scanner, "Enter student roll number: ");
        String grade = getStringInput(scanner, "Enter student grade: ");

        Student newStudent = new Student(name, rollNumber, grade);
        sms.addStudent(newStudent);
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.println("\n--- Remove Student ---");
        String rollNumber = getStringInput(scanner, "Enter roll number of student to remove: ");
        sms.removeStudent(rollNumber);
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.println("\n--- Search Student ---");
        String rollNumber = getStringInput(scanner, "Enter roll number of student to search: ");
        Student foundStudent = sms.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
}

