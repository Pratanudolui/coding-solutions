import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // A robust token reader that mimics C++ cin behavior across multiple lines
    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        String nToken = nextToken();
        if (nToken == null) return;
        
        n = Integer.parseInt(nToken);
        int q = Integer.parseInt(nextToken());

        cnt = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            long val = Long.parseLong(nextToken());
            cnt[i] = Long.bitCount(val);
        }

        // Build prefix sum array
        for (int i = 1; i <= n; i++) {
            cnt[i] += cnt[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        
        // Process all queries safely
        for (int i = 0; i < q; i++) {
            String qToken = nextToken();
            if (qToken == null) break;
            
            long x = Long.parseLong(qToken);
            long ans = -1;
            long low = 1;
            long high = n;

            while (low <= high) {
                long mid = (low + high) / 2;
                if (func(mid, x)) {
                    ans = mid;
                    high = mid - 1; 
                } else {
                    low = mid + 1; 
                }
            }
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }

    private static boolean func(long mid, long k) {
        for (int i = 0; i <= n - mid; i++) {
            if (cnt[(int)(i + mid)] - cnt[i] >= k) {
                return true;
            }
        }
        return false;
    }
}
