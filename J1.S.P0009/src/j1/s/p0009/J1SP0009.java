package j1.s.p0009;

public class J1SP0009 {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 45;
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
