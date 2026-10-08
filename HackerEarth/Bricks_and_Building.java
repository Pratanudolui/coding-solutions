import java.io.InputStream;
import java.util.Arrays;

public class TestClass {

    private static final int MAX = 100000;

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
        FastScanner fs = new FastScanner();
        if (!fs.hasNext()) return;

        int n = fs.nextInt();
        int[] freq = new int[MAX + 1];

        for (int i = 0; i < n; i++) {
            int h = fs.nextInt();
            if (h <= MAX) {
                freq[h]++;
            }
        }

        // Memoization array for queries
        int[] memo = new int[MAX + 1];
        Arrays.fill(memo, -1);

        int q = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int k = fs.nextInt();

            if (k > MAX) {
                sb.append(0).append("\n");
                continue;
            }

            // Lazy computation on demand
            if (memo[k] == -1) {
                int count = 0;
                for (int m = k; m <= MAX; m += k) {
                    count += freq[m];
                }
                memo[k] = count;
            }

            sb.append(memo[k]).append("\n");
        }

        System.out.print(sb);
    }
}
