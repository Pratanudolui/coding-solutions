import java.io.InputStream;
import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        int t = scanner.nextInt();
        if (t <= 0) return;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();

            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }

            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = scanner.nextInt();
            }

            int offset = 2 * n;
            int maxIdx = 4 * n + 2;
            int[] diff = new int[maxIdx + 2];

            for (int i = 0; i < n; i++) {
                int pos = x[i];
                int range = r[i];

                int l, right;
                if (pos > 0) {
                    l = Math.max(1, pos - range);
                    right = pos + range;
                } else {
                    l = pos - range;
                    right = Math.min(-1, pos + range);
                }

                // Clamp boundaries to target window [-2N, 2N]
                l = Math.max(-2 * n, Math.min(2 * n, l));
                right = Math.max(-2 * n, Math.min(2 * n, right));

                if (l <= right) {
                    diff[l + offset]++;
                    diff[right + offset + 1]--;
                }
            }

            // Calculate prefix sum to get coverage counts
            int[] coverage = new int[maxIdx + 1];
            int current = 0;
            for (int i = 0; i <= maxIdx; i++) {
                current += diff[i];
                coverage[i] = current;
            }

            // Answer queries
            for (int i = 0; i < q; i++) {
                int k = scanner.nextInt();
                if (k >= -2 * n && k <= 2 * n) {
                    sb.append(coverage[k + offset]).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    // Fast Input Reader
    static class FastScanner {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024 * 64];
        private int head = 0;
        private int tail = 0;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = stream.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return -1;
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res * sgn;
        }
    }
}
