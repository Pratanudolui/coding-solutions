import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] a = new long[n + 1];
        line = br.readLine();
        st = new StringTokenizer(line);
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        // dp[j] stores the maximum sum using j elements so far
        long[] dp = new long[k + 1];
        for (int j = 1; j <= k; j++) {
            dp[j] = Long.MIN_VALUE; // Represents unreachable states
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Iterate backwards to ensure each element is used at most once for size j
            int limit = Math.min(i, k);
            for (int j = limit; j >= 1; j--) {
                if (dp[j - 1] != Long.MIN_VALUE) {
                    long contribution = a[i] * (j % m);
                    if (dp[j - 1] + contribution > dp[j]) {
                        dp[j] = dp[j - 1] + contribution;
                    }
                }
            }
        }

        System.out.println(dp[k]);
    }
}
