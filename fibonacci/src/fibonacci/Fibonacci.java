package fibonacci;

import java.util.Scanner;

public class Fibonacci {

    private final static Scanner sc = new Scanner(System.in);

    public static long fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.print("Enter number which you want: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < 0) {
                    System.err.println("VUI LONG NHAP SO DUONG");
                    System.out.print("Enter again: ");
                } else {
                    System.out.println("The " + n + " sequence fibonacci: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(fibo(i));
                        if (i < n - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("VUI LONG NHAP SO NGUYEN");
                System.out.print("Enter again: ");
            }
        }
    }

}
