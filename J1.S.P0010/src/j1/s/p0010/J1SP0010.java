package j1.s.p0010;

import java.util.Random;
import java.util.Scanner;

public class J1SP0010 {

    private final static Scanner sc = new Scanner(System.in);
    private final static Random rd = new Random();

    public static void display(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int linearSearch(int[] arr, int key) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of array:");
        int length = Integer.parseInt(sc.nextLine());

        System.out.println("Enter search value:");
        int search = Integer.parseInt(sc.nextLine());

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        J1SP0010 ls = new J1SP0010();
        System.out.print("The array: ");
        ls.display(array);

        int foundIndex = ls.linearSearch(array, search);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
    }

}
