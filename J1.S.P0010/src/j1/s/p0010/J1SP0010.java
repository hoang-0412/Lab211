package j1.s.p0010;

import java.util.ArrayList;
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

//    public static int linearSearch(int[] arr, int key) {
//        int size = arr.length;
//        for (int i = 0; i < size; i++) {
//            if (arr[i] == key) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
    public static ArrayList<Integer> linearSearch(int[] arr, int key) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                results.add(i);
            }
        }
        return results;
    }

    private static boolean checkInputYN() {
        while (true) {
            String input = sc.nextLine();
            if (input.equals("Y")) {
                return true;
            }
            if (input.equals("N")) {
                return false;
            }
            System.err.println("Please input Y or N!");
            System.out.print("Enter again: ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of array:");
        int length;

        while (true) {
            try {
                length = Integer.parseInt(sc.nextLine());
                if (length <= 0) {
                    System.err.println("PLEASE ENTER A POSITIVE NUMBER");
                    System.out.print("ENTER AGAIN: ");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.err.println("PLEASE ENTER A INTEGER NUMBER");
                System.out.print("ENTER AGAIN: ");
            }
        }

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rd.nextInt(length);
//            array[i] = new Random().nextInt(length);
        }

        int searchValue;
        while (true) {
            System.out.print("The array: ");
            display(arr);
            System.out.println();

            System.out.print("Enter search value: ");
            while (true) {
                try {
                    searchValue = Integer.parseInt(sc.nextLine());
                    break;

                } catch (NumberFormatException e) {
                    System.err.println("PLEASE ENTER A INTEGER NUMBER");
                    System.out.print("ENTER AGAIN: ");
                }
            }

            ArrayList<Integer> result = linearSearch(arr, searchValue);
            if (result.isEmpty()) {
                System.out.println(searchValue + " was not found in the array.");

            } else {
                System.out.print("Found " + searchValue + " at index: ");
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i));

                    if (i < result.size()) {
                        System.out.print(", ");
                    }
                }

                System.out.println();
            }

            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to finish.");
            if (!checkInputYN()) {
                break;
            }
        }

//        J1SP0010 ls = new J1SP0010();
//        System.out.print("The array: ");
//        display(array);
//
//        int foundIndex = ls.linearSearch(array, search);
//        System.out.println("\nFound " + search + " at index: " + foundIndex);
    }

}
