import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        
        if (!sc.hasNext()) return;
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long[] a = new long[n];
        long totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            totalSum += a[i];
        }
        
        // Sort the array in non-decreasing order
        Arrays.sort(a);
        
        // Subtract the k largest elements
        long largestKSum = 0;
        for (int i = n - k; i < n; i++) {
            largestKSum += a[i];
        }
        
        long specialty = totalSum - largestKSum;
        System.out.println(specialty);
    }

    // Fast I/O class for large input sizes
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
