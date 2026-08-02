import java.io.InputStream;
import java.io.IOException;

public class Main {

    // Fast I/O implementation for large input sizes
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        public int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int q = sc.nextInt();

        if (n == -1) return;

        // prefixMoves[i] stores the cumulative moves mod 2 up to index i
        int[] prefixMoves = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            // Number of times `a` can be halved until 0 equals 32 - numberOfLeadingZeros(a)
            int moves = 32 - Integer.numberOfLeadingZeros(a);
            prefixMoves[i] = (prefixMoves[i - 1] + moves) % 2;
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Total moves parity in range [l, r]
            int movesParity = (prefixMoves[r] - prefixMoves[l - 1] + 2) % 2;

            if (movesParity % 2 != 0) {
                sb.append("Mishki\n");
            } else {
                sb.append("Hacker\n");
            }
        }

        System.out.print(sb);
    }
}
