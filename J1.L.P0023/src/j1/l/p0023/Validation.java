package j1.l.p0023;

import java.util.Scanner;

public class Validation {

    private final Scanner sc = new Scanner(System.in);

    public String InputString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("You need to enter something to continue the program !");
                System.out.print("Enter again : ");
                continue;
            }
            return input;
        }
    }

    public int InputInt() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                if (input <= 0) {
                    System.err.print("Please enter a positive integer number: ");
                    continue;
                }
                return input;
            } catch (Exception e) {
                sc.nextLine();
                System.err.print("Please enter a positive integer number: ");
                continue;
            }
        }
    }

    public int CheckChoice(int min, int max) {
        while (true) {
            String input = sc.nextLine();
            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.print("Please enter positive integer between " + min + "-" + max + ": ");
                }
            } catch (Exception e) {
                System.err.print("Please input an integer number between " + min + "-" + max + ". Enter again: ");
            }
        }
    }

    public boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N!");
            System.out.print("Enter again: ");
        }
    }
}
