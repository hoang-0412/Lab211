package j1.s.p0009;

import java.util.Scanner;
import java.util.ArrayList;

public class J1SP0009 {

    private final static Scanner sc = new Scanner(System.in);

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of sequence fibonacci: ");
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
//        int n = 45;
                if (n <= 0) {
                    System.err.println("PLEASE ENTER POSITIVE NUMBER");
                    System.out.print("ENTER AGAIN: ");
                    continue;
                }

                ArrayList<Long> rs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    rs.add(fibonacci(i));
                }

                System.out.println("The " + n + " sequence fibonacci: ");
//                for (int i = 0; i < n; i++) {
//                    System.out.print(fibonacci(i));
//                    if (i < n - 1) {
//                        System.out.print(", ");
//                    }
//                }
                for (int j = 0; j < rs.size(); j++) {
                    System.out.print(rs.get(j));

                    if (j < rs.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();

                System.out.print("Enter index: ");
                while (true) {
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (id < 1 || id > rs.size()) {
                            System.err.println("PLEASE ENTER BETWEEN 1-" + rs.size());
                            System.out.print("ENTER AGAIN: ");
                            continue;
                        }

                        System.out.println("Value at index " + id + " is: " + rs.get(id - 1));
                        break;

                    } catch (NumberFormatException e) {
                        System.err.println("PLEASE ENTER BETWEEN 1-" + rs.size());
                        System.out.print("ENTER AGAIN: ");
                    }
                }
                break;

            } catch (NumberFormatException e) {
                System.err.println("PLEASE ENTER INTEGER NUMBER");
                System.out.print("Enter again: ");
            }
        }
    }
}
