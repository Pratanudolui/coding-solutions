import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass {

    // Helper method to recursively check if string can be split into 'parts' distinct non-empty substrings
    private static boolean canSplit(String s, int parts, java.util.Set<String> used) {
        if (parts == 1) {
            // Last part must be non-empty and not already used
            return !s.isEmpty() && !used.contains(s);
        }

        // Try every possible split position for the current part
        for (int i = 1; i <= s.length() - parts + 1; i++) {
            String sub = s.substring(0, i);
            if (!used.contains(sub)) {
                used.add(sub);
                if (canSplit(s.substring(i), parts - 1, used)) {
                    return true;
                }
                used.remove(sub); // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        while (t-- > 0) {
            String s = br.readLine();
            if (s == null) break;
            s = s.trim();

            // A string of length < 4 cannot be divided into 4 non-empty parts
            if (s.length() < 4) {
                wr.println("NO");
                continue;
            }

            boolean possible = canSplit(s, 4, new java.util.HashSet<>());
            if (possible) {
                wr.println("YES");
            } else {
                wr.println("NO");
            }
        }
        wr.flush();
    }
}
