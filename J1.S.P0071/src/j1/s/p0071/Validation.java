package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String planInput = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public String checkString() {
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("PLEASE ENTER SOMETHING TO CONTINUE");
            } else {
                return input;
            }
        }
    }

    public int checkInt() {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException ex) {
                System.err.println("PLEASE ENTER A POSITIVE NUMBER");
                System.out.print("ENTER AGAIN:");
            }
        }
    }

    public int checkChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (min <= choice && choice <= max) {
                    return choice;
                }
                System.err.println("PLEASE ENTER A POSITIVE NUMBER BETWEEN " + min + "-" + max);
                System.out.print("ENTER AGAIN: ");
            } catch (NumberFormatException ex) {
                System.err.println("PLEASE ENTER A POSITIVE NUMBER BETWEEN " + min + "-" + max);
                System.out.print("ENTER AGAIN: ");
            }
        }
    }

    public String checkDate() {
        while (true) {
            try {
                String input = sc.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(input);
                if (input.equalsIgnoreCase(format.format(date))) {
                    return input;
                } else {
                    System.err.println("PLEASE ENTER RIGHT FORMAT 'dd-MMMM-yyyy'");
                    System.out.print("ENTER AGAIN: ");
                }
            } catch (NumberFormatException | ParseException ex) {
                System.err.println("PLEASE ENTER RIGHT FORMAT 'dd-MMMM-yyyy'");
                System.out.print("ENTER AGAIN: ");
            }
        }
    }

    public String checkTaskTypeId() {
        while (true) {
            int choice = checkChoice(1, 4);
            String type = null;
            switch (choice) {
                case 1:
                    type = "code";
                    break;
                case 2:
                    type = "test";
                    break;
                case 3:
                    type = "design";
                    break;
                case 4:
                    type = "review";
            }
            return type;
        }
    }

    public String checkPlan() {
        while (true) {
            String input = checkString();
            if (input.matches(planInput)
                    && Double.parseDouble(input) >= 8.0
                    && Double.parseDouble(input) <= 17.5) {
                return input;
            } else {
                System.err.println("PLEASE ENTER RIGHT FORMAT 'xx.5' or 'xx.0' AND THE VALUE IS BETWEEN 8.0-17.5");
                System.out.print("ENTER AGAIN: ");
            }
        }
    }
}
