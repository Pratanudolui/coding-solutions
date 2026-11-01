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
            line = br.readLine();
            if (line == null || line.trim().isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            line = br.readLine();
            st = new StringTokenizer(line);
            Integer[] setBits = new Integer[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                setBits[i] = Integer.bitCount(num);
            }

            // Sort in descending order to pick the largest set-bit counts
            Arrays.sort(setBits, Collections.reverseOrder());

            long maxCakes = 0;
            for (int i = 0; i < k; i++) {
                maxCakes += setBits[i];
            }

            sb.append(maxCakes).append("\n");
        }

        System.out.print(sb);
    }
}
