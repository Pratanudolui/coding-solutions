import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static final int MAX = 1000001;
    static boolean[] isPrime = new boolean[MAX];

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int p = 2; p * p < MAX; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < MAX; i += p) {
                    isPrime[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        sieve();

        FastScanner sc = new FastScanner();
        if (!sc.hasNext()) return;

        int n = sc.nextInt();
        int minPrime = Integer.MAX_VALUE;
        int maxPrime = Integer.MIN_VALUE;
        boolean foundPrime = false;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (isPrime[val]) {
                foundPrime = true;
                if (val < minPrime) minPrime = val;
                if (val > maxPrime) maxPrime = val;
            }
        }

        if (!foundPrime) {
            System.out.println(-1);
        } else {
            System.out.println(maxPrime - minPrime);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
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
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
