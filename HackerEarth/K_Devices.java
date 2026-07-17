import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len == -1) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return Long.MIN_VALUE;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();
        int K = fs.nextInt();

        long[] x = new long[N];
        long[] dist2 = new long[N];

        for (int i = 0; i < N; i++) {
            x[i] = fs.nextLong();
        }

        for (int i = 0; i < N; i++) {
            long y = fs.nextLong();
            dist2[i] = x[i] * x[i] + y * y;
        }

        Arrays.sort(dist2);

        long need = dist2[K - 1];
        long ans = (long) Math.sqrt(need);
        while (ans * ans < need) ans++;

        System.out.println(ans);
    }
}
