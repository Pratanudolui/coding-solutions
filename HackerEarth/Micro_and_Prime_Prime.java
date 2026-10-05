import java.io.InputStream;
import java.util.Arrays;

public class TestClass {

    private static final int MAX = 1000000;
    private static final boolean[] isPrime = new boolean[MAX + 1];
    private static final int[] ppPrefix = new int[MAX + 1];

    private static void precompute() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= MAX; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= MAX; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int currentPrimeCount = 0;
        int ppCount = 0;

        for (int i = 1; i <= MAX; i++) {
            if (isPrime[i]) {
                currentPrimeCount++;
            }

            if (isPrime[currentPrimeCount]) {
                ppCount++;
            }

            ppPrefix[i] = ppCount;
        }
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
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int l = fs.nextInt();
            int r = fs.nextInt();

            int ans = ppPrefix[r] - ppPrefix[l - 1];
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
