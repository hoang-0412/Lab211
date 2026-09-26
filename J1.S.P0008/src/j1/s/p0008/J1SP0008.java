package j1.s.p0008;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J1SP0008 {

    private final static Scanner sc = new Scanner(System.in);
    private final Map<Character, Integer> charCounter = new HashMap<>();
    private final Map<String, Integer> wordCounter = new HashMap<>();

    public void analyze(String content) {
        for (char c : content.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                continue;
            }

            if (!charCounter.containsKey(c)) {
                charCounter.put(c, 1);

            } else {
                charCounter.put(c, (charCounter.get(c)) + 1);
            }
        }

        StringTokenizer stk = new StringTokenizer(content);
        while (stk.hasMoreTokens()) {
            String tk = stk.nextToken();

            if (!wordCounter.containsKey(tk)) {
                wordCounter.put(tk, 1);

            } else {
                wordCounter.put(tk, (wordCounter.get(tk)) + 1);
            }
        }
    }

    public void display() {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    public static void main(String[] args) {
        System.out.println("Enter your content: ");
        String content = sc.nextLine();

        J1SP0008 counter = new J1SP0008();
        counter.analyze(content);
        counter.display();
    }

}
