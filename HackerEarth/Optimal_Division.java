import java.io.InputStream;

public class Main {

    private static boolean isPossible(long[] a, int n, int m, long target) {
        int segments = 1;
        long currentOr = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > target) {
                return false;
            }
            if ((currentOr | a[i]) <= target) {
                currentOr |= a[i];
            } else {
                segments++;
                currentOr = a[i];
            }
        }

        return segments <= m;
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        if (!sc.hasNext()) return;

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[] a = new long[n];
            long low = 0;
            long high = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                low = Math.max(low, a[i]);
                high |= a[i];
            }

            long ans = high;

            while (low <= high) {
                long mid = low + (high - low) / 2;

                if (isPossible(a, n, m, mid)) {
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

    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public boolean hasNext() throws Exception {
            int c = read();
            while (c <= 32 && c != -1) {
                c = read();
            }
            if (c == -1) return false;
            head--;
            return true;
        }

        public int nextInt() throws Exception {
            int c = read();
            while (c <= 32) c = read();
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public long nextLong() throws Exception {
            int c = read();
            while (c <= 32) c = read();
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }
}
