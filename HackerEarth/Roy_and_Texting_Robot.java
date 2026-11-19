import java.io.*;

public class TestClass {
    private static final char[] KEY_OF = new char[128];
    private static final int[] PRESSES = new int[128];

    private static void mapKey(char key, String chars) {
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            KEY_OF[c] = key;
            PRESSES[c] = i + 1;
        }
    }

    static {
        mapKey('0', "_0");
        mapKey('1', ".,?!1");
        mapKey('2', "abc2");
        mapKey('3', "def3");
        mapKey('4', "ghi4");
        mapKey('5', "jkl5");
        mapKey('6', "mno6");
        mapKey('7', "pqrs7");
        mapKey('8', "tuv8");
        mapKey('9', "wxyz9");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine();
            if (s == null) break;
            s = s.trim();

            char currentKey = '1';
            long totalTime = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                char targetKey = KEY_OF[c];
                if (targetKey != 0) {
                    if (targetKey != currentKey) {
                        totalTime += 1;
                        currentKey = targetKey;
                    }
                    totalTime += PRESSES[c];
                }
            }

            out.append(totalTime).append('\n');
        }

        System.out.print(out);
    }
}
