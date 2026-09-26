package j1.s.p0009;

import java.util.Scanner;

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
        int n = Integer.parseInt(sc.nextLine());
//        int n = 45;
        System.out.println("The " + n + "sequence fibonacci: ");

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i));
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
