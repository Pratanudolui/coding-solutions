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
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            int operations = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 != 0) { // If the element is odd
                    if (i + 1 < n && a[i + 1] % 2 != 0) {
                        // Both current and next are odd: 1 operation makes both even
                        operations += 1;
                        i++; // Skip the next element since it's now handled
                    } else {
                        // Current is odd and next is even (or no next element): takes 2 operations
                        operations += 2;
                    }
                }
            }

            sb.append(operations).append("\n");
        }

        System.out.print(sb);
    }
}
