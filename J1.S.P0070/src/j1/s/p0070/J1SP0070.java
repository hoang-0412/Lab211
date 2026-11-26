package j1.s.p0070;

import java.util.Locale;
import java.util.Scanner;

public class J1SP0070 {

    private final static Scanner sc = new Scanner(System.in);
    private final static LoginService ls = new LoginService();

    private static int checkChoice(int min, int max) {
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

    public static void main(String[] args) {
        while (true) {
            ls.displayMenu();
            int choice = checkChoice(1, 3);
            switch (choice) {
                case 1:
                    ls.setLocale(new Locale("vi", "VN"));
                    ls.login();
                    break;

                case 2:
                    ls.setLocale(new Locale("en", "US"));
                    ls.login();
                    break;

                case 3:
                    return;
            }
        }
    }

}
