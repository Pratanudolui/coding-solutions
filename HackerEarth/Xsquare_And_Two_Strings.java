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
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            boolean[] present = new boolean[26];
            for (int i = 0; i < s1.length(); i++) {
                present[s1.charAt(i) - 'a'] = true;
            }

            boolean found = false;
            for (int i = 0; i < s2.length(); i++) {
                if (present[s2.charAt(i) - 'a']) {
                    found = true;
                    break;
                }
            }

            if (found) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb);
    }
}
