import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total no. of students: ");
        int n = scanner.nextInt();

        String[] NAME = new String[n];
        String[] COURSE = new String[n];
        double[][] CAMARKS= new double[n][5];
        double[] MIDTERMMARKS = new double[n];
        double[] TOTALMARKS = new double[n];
        double[] OVERALLPERCENT = new double[n];
        char[] grades = new char[n];
        for (int a = 0; a < n; a++) {
            System.out.println("Provide details for student " + (a+1) + ":");
            System.out.print("Name: ");
            NAME[a] = scanner.next();
            System.out.print("Course opt: ");
            COURSE[a] = scanner.next();
            System.out.print("Enter the scores for 5 subjects (out of 100),with spaces in between: ");
            for (int b = 0; b < 5; b++) {
                CAMARKS[a][b] = scanner.nextDouble();
            }
            System.out.print(" Marks scored in Midterm (out of 100): ");
            MIDTERMMARKS[a] = scanner.nextDouble();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            double caTotal = 0;
            for (int j = 0; j < 5; j++) {
                caTotal += CAMARKS[i][j];
            }
            double caPercentage = (caTotal / 500.0) * 35.0; 
            double midtermPercentage = (MIDTERMMARKS[i] / 100.0) * 75.0; 
            TOTALMARKS[i] = caPercentage + midtermPercentage;
            OVERALLPERCENT[i] = TOTALMARKS[i];
            if (OVERALLPERCENT[i] >= 90) {
                grades[i] = 'A';
            } else if (OVERALLPERCENT[i] >=75) {
                grades[i] = 'B';
            } else if (OVERALLPERCENT[i] >= 60) {
                grades[i] = 'C';
            } else {
                grades[i] = 'D';
            }
        }
        System.out.printf("%-25s%-15s%-15s%-15s%-15s%-15s%-20s%-15s\n", "Name", "Course", "CA1", "CA2", "CA3", "CA4",
                "Midterm", "Overall%");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-25s%-15s", NAME[i], COURSE[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-15.2f", CAMARKS[i][j]);
            }
            System.out.printf("%-15.2f%-10.2f%-3c\n", MIDTERMMARKS[i], OVERALLPERCENT[i], grades[i]);
        }
        scanner.close();
    }
}
