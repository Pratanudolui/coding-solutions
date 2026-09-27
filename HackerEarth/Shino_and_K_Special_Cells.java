import java.io.*;

public class TestClass {

    private static final int MOD = 1000000007;
    private static final int MAX = 200005;

    private static long[] fact = new long[MAX];
    private static long[] invFact = new long[MAX];

    // Precompute factorials and modular inverse factorials
    private static void precompute() {
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1], MOD);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    private static long modInverse(long base, long exp) {
        long res = 1;
        base %= MOD;
        long power = exp - 2; // Fermat's Little Theorem
        while (power > 0) {
            if ((power & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            power >>= 1;
        }
        return res;
    }

    // Combination nCr % MOD
    private static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Fast Scanner for IO efficiency
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024 * 64];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer, 0, buffer.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private int readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        public boolean hasNext() {
            int b = readByte();
            while (b != -1 && b <= ' ') {
                b = readByte();
            }
            if (b == -1) return false;
            ptr--;
            return true;
        }

        public int nextInt() {
            int b = readByte();
            while (b <= ' ') {
                if (b == -1) return -1;
                b = readByte();
            }
            int res = 0;
            while (b > ' ') {
                if (b < '0' || b > '9') {
                    b = readByte();
                    continue;
                }
                res = res * 10 + (b - '0');
                b = readByte();
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        precompute();
        FastScanner fs = new FastScanner();

        if (!fs.hasNext()) return;
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();

            long totalHappiness = 0;

            for (int i = 0; i < k; i++) {
                int x = fs.nextInt();
                int y = fs.nextInt();
                long h = fs.nextInt();

                // Paths from (1,1) to (x,y)
                long paths1 = nCr(x - 1 + y - 1, x - 1);

                // Paths from (x,y) to (n,m)
                long paths2 = nCr(n - x + m - y, n - x);

                // Total contribution of cell (x, y)
                long cellContribution = (paths1 * paths2) % MOD;
                cellContribution = (cellContribution * (h % MOD)) % MOD;

                totalHappiness = (totalHappiness + cellContribution) % MOD;
            }

            System.out.println(totalHappiness);
        }
    }
}
