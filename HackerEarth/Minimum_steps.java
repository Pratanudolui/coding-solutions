import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        if (!sc.hasNext()) return;
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] revArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            revArr[n - 1 - i] = arr[i]; // Reversed array to find LDS using LIS logic
        }

        int maxLIS = getLIS(arr, n);
        int maxLDS = getLIS(revArr, n);

        int minSteps = n - Math.max(maxLIS, maxLDS);
        System.out.println(minSteps);
    }

    // O(N log N) Longest Increasing Subsequence algorithm
    private static int getLIS(int[] arr, int n) {
        int[] tails = new int[n];
        int len = 0;

        for (int x : arr) {
            int i = Arrays.binarySearch(tails, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            tails[i] = x;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    // Fast I/O helper for large input sizes (N up to 5 * 10^5)
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
    }
}
