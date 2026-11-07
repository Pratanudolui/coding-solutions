import java.io.*;
import java.util.*;

public class TestClass {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            long[] dp = new long[n + 1];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                long[] nextDp = new long[n + 1];

                for (int bal = 0; bal <= n; bal++) {
                    if (dp[bal] == 0) continue;

                    if (ch == '(' || ch == '?') {
                        if (bal + 1 <= n) {
                            nextDp[bal + 1] = (nextDp[bal + 1] + dp[bal]) % MOD;
                        }
                    }

                    if (ch == ')' || ch == '?') {
                        if (bal - 1 >= 0) {
                            nextDp[bal - 1] = (nextDp[bal - 1] + dp[bal]) % MOD;
                        }
                    }
                }
                dp = nextDp;
            }

            sb.append(dp[0]).append("\n");
        }

        System.out.print(sb);
    }
}
