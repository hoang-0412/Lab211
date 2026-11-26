package j1.l.p0021;

import java.util.Scanner;

public class Validation {

    private final Scanner sc = new Scanner(System.in);

    public int checkChoice(int min, int max) {
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.print("Please input an integer number between " + min + "-" + max + ". Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Please input an integer number between " + min + "-" + max + ". Enter again: ");
            }
        }
    }

    public String checkString() {
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.print("Please enter valid input. Enter again: ");
                continue;
            }
            return input;
        }
    }

    public static boolean isValidStudentId(String id) {
        return id.matches("^(HE|HA|HS)\\d{2}\\d{4}$");
    }

    public String checkInputId() {
        while (true) {
            String id = sc.nextLine().trim().toUpperCase();

            if (Validation.isValidStudentId(id)) {
                return id;
            }

            System.err.println("INVALID ID FORMAT");
            System.out.print("Format: [HE/HA/HS + Your Cohort + 4 digits] Eg: HE181234,. Please enter again: ");
        }
    }
    
    public static boolean isValidSemester(String id) {
        return id.matches("^(SP|SU|FA)\\d{2}$");
    }
    
    public String checkInputSemester() {
        while (true) {
            String semester = sc.nextLine().trim().toUpperCase();

            if (Validation.isValidSemester(semester)) {
                return semester;
            }

            System.err.println("INVALID SEMESTER FORMAT");
            System.out.print("Format: [SP|SU|FA + the last two characters of the school year] Eg: SP26, SU27,. Please enter again: ");
        }
    }

    public boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.equals("Y")) {
                return true;
            }
            if (result.equals("N")) {
                return false;
            }
            System.err.println("Please input Y or N!");
            System.out.print("Enter again: ");
        }
    }

    public boolean checkInputUD() {
        while (true) {
            String result = sc.nextLine();
            if (result.equals("U")) {
                return true;
            }
            if (result.equals("D")) {
                return false;
            }
            System.err.println("Please input U or D!");
            System.out.print("Enter again: ");
        }
    }

    public String checkCourseName() {
        while (true) {
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("Java")
                    || courseName.equalsIgnoreCase(".Net")
                    || courseName.equalsIgnoreCase("C/C++")) {
                return courseName;
            } else {
                System.err.println("There are only three course: Java, .Net, C/C++");
                System.out.print("Please enter again: ");
            }
        }
    }
}
