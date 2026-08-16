import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;
        
        int T = Integer.parseInt(line.trim());

        while (T-- > 0) {
            // Read N and M
            String[] nm = br.readLine().trim().split("\\s+");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);

            int[] A = new int[N];
            int[] B = new int[N];

            for (int i = 0; i < N; i++) {
                String[] pair = br.readLine().trim().split("\\s+");
                A[i] = Integer.parseInt(pair[0]);
                B[i] = Integer.parseInt(pair[1]);
            }

            if (canReachSum(N, M, A, B)) {
                wr.println("YES");
            } else {
                wr.println("NO");
            }
        }

        wr.flush();
    }

    private static boolean canReachSum(int N, int M, int[] A, int[] B) {
        // dp[j] will store whether sum 'j' is achievable
        boolean[] dp = new boolean[M + 1];
        dp[0] = true;

        for (int i = 0; i < N; i++) {
            boolean[] nextDp = new boolean[M + 1];
            int a = A[i];
            int b = B[i];

            for (int j = 0; j <= M; j++) {
                if (dp[j]) {
                    if (j + a <= M) {
                        nextDp[j + a] = true;
                    }
                    if (j + b <= M) {
                        nextDp[j + b] = true;
                    }
                }
            }

            dp = nextDp;
        }

        return dp[M];
    }
}
