import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        int T = Integer.parseInt(line.trim());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] x = new long[n];
            long sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x[i] = Long.parseLong(st.nextToken());
                sum += x[i];
            }

            long m = Long.parseLong(br.readLine().trim());

            // Simplify M to within one year cycle
            m = m % sum;
            if (m == 0) {
                m = sum;
            }

            // Find the day on which the milestone is reached
            int ansDay = -1;
            for (int i = 0; i < n; i++) {
                if (x[i] >= m) {
                    ansDay = i + 1; // 1-based index for day number
                    break;
                }
                m -= x[i];
            }

            System.out.println(ansDay);
        }
    }
}
