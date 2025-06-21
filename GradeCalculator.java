import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        for (int student = 1; student <= numStudents; student++) {
            System.out.println("\n--- Student " + student + " ---");
            System.out.print("Enter the number of subjects: ");
            int numSubjects = input.nextInt();

            double[] marks = new double[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                while (true) {
                    System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                    double mark = input.nextDouble();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                }
            }

            double totalMarks = 0;
            for (double mark : marks) {
                totalMarks += mark;
            }

            double averagePercentage = totalMarks / numSubjects;

            String grade;
            if (averagePercentage >= 90 && averagePercentage <= 100) {
                grade = "A";
            } else if (averagePercentage >= 80 && averagePercentage < 90) {
                grade = "B";
            } else if (averagePercentage >= 70 && averagePercentage < 80) {
                grade = "C";
            } else if (averagePercentage >= 60 && averagePercentage < 70) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.printf("\nTotal Marks: %.2f\n", totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
            System.out.println("Grade: " + grade);
        }

        input.close();
    }
}