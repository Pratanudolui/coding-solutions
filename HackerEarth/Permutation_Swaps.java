import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        if (!sc.hasNext()) return;

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            long totalSum = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                totalSum += a[i];
            }

            long targetTotalSum = (long) n * (n + 1) / 2;
            if (totalSum != targetTotalSum) {
                sb.append("NO\n");
                continue;
            }

            boolean possible = true;
            long prefixSum = 0;

            for (int i = 0; i < n; i++) {
                prefixSum += a[i];
                long requiredPrefixSum = (long) (i + 1) * (i + 2) / 2;
                
                // For a valid target permutation sorted as 1, 2, ..., N,
                // the minimum prefix sum needed at step i (1-indexed) is (i * (i + 1)) / 2.
                long minRequiredPrefixSum = (long) (i + 1) * (i + 2) / 2;
            }

            // Let's verify prefix condition:
            // At index i (0-based), the sum of the smallest possible prefix in a permutation is (i+1)*(i+2)/2? 
            // No, the prefix sum of 1..N up to size k = i + 1 is (i + 1) * (i + 2) / 2.
            
            prefixSum = 0;
            for (int i = 0; i < n; i++) {
                prefixSum += a[i];
                long minPrefix = (long) (i + 1) * (i + 2) / 2; // smallest possible elements 1..k sum
                // Actually, prefix sum can be larger than or equal to k*(k+1)/2
                long k = i + 1;
                if (prefixSum < k * (k + 1) / 2) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        boolean hasNext() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return false;
                st = new StringTokenizer(line);
            }
            return true;
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }
    }
}
