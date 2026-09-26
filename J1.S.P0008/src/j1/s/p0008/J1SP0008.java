package j1.s.p0008;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J1SP0008 {

    private final static Scanner sc = new Scanner(System.in);
//    private final Map<Character, Integer> charCounter = new HashMap<>();
//    private final Map<String, Integer> wordCounter = new HashMap<>();

//    public void analyze(String content) {
//        for (char c : content.toCharArray()) {
//            if (Character.isSpaceChar(c)) {
//                continue;
//            }
//
//            if (!charCounter.containsKey(c)) {
//                charCounter.put(c, 1);
//
//            } else {
//                charCounter.put(c, (charCounter.get(c)) + 1);
//            }
//        }
//
//        StringTokenizer stk = new StringTokenizer(content);
//        while (stk.hasMoreTokens()) {
//            String tk = stk.nextToken();
//
//            if (!wordCounter.containsKey(tk)) {
//                wordCounter.put(tk, 1);
//
//            } else {
//                wordCounter.put(tk, (wordCounter.get(tk)) + 1);
//            }
//        }
//    }
    public ArrayList<Map<Character, Integer>> analyzeCharacter(String content) {
        Map<Character, Integer> charCounter = new HashMap<>();
        ArrayList<Map<Character, Integer>> resultCharCount = new ArrayList<>();

        for (char c : content.toCharArray()) {
            if (!charCounter.containsKey(c)) {
                charCounter.put(c, 1);
            } else {
                charCounter.put(c, (charCounter.get(c)) + 1);
            }
        }

        resultCharCount.add(charCounter);
        return resultCharCount;
    }

    public ArrayList<Map<String, Integer>> analyzeWord(String content) {
        Map<String, Integer> wordCounter = new HashMap<>();
        ArrayList<Map<String, Integer>> resultWordCount = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(content);

        while (stk.hasMoreTokens()) {
            String token = stk.nextToken();
            String[] parts = token.split("[^a-zA-Z0-9]+");

            for (String part : parts) {
                if (part.isEmpty()) {
                    continue;
                }

                if (!wordCounter.containsKey(part)) {
                    wordCounter.put(part, 1);
                } else {
                    wordCounter.put(part, wordCounter.get(part) + 1);
                }
            }
        }

        resultWordCount.add(wordCounter);
        return resultWordCount;
    }

//    public void display() {
//        System.out.println(wordCounter);
//        System.out.println(charCounter);
//    }
    public static void main(String[] args) {
        J1SP0008 counter = new J1SP0008();
        System.out.println("Enter your content: ");
        String content = sc.nextLine();

        while (true) {
            if (content.isEmpty()) {
                System.err.println("PLEASE ENTER SOMETHING TO CONTINUE");
                content = sc.nextLine();

            } else {
                ArrayList<Map<String, Integer>> resultWordCount = counter.analyzeWord(content);
                ArrayList<Map<Character, Integer>> resultCharCount = counter.analyzeCharacter(content);

                if (resultWordCount.get(0).isEmpty()) {
                    System.err.println("NO WORDS FOUND");
                } else {
                    System.out.println(resultWordCount.get(0));
                }
                System.out.println(resultCharCount.get(0));
                break;
            }
        }

//        counter.analyze(content);
//        counter.display();
    }

}
