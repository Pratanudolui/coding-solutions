import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        List<String> seen = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) break;
            String current = line.trim();

            int niceness = 0;
            // Count how many previous strings are lexicographically smaller
            for (String prev : seen) {
                if (prev.compareTo(current) < 0) {
                    niceness++;
                }
            }

            sb.append(niceness).append("\n");
            seen.add(current);
        }

        System.out.print(sb);
    }
}
