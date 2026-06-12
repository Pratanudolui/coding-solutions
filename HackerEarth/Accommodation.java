import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] c = new int[M];

        for (int i = 0; i < M; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int coin : c) {
            for (int j = coin; j <= N; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}
