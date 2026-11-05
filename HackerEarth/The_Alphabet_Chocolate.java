import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine().trim();
            long totalTaste = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (isVowel(ch)) {
                    long leftChoices = i + 1;
                    long rightChoices = n - i;
                    totalTaste += leftChoices * rightChoices;
                }
            }

            sb.append(totalTaste).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
