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

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int[] rating = new int[n];
        int[] tablets = new int[n];

        Arrays.fill(tablets, 1);

        for (int i = 0; i < n; i++)
            rating[i] = fs.nextInt();

        for (int i = 1; i < n; i++)
            if (rating[i] > rating[i - 1])
                tablets[i] = tablets[i - 1] + 1;

        for (int i = n - 2; i >= 0; i--)
            if (rating[i] > rating[i + 1])
                tablets[i] = Math.max(tablets[i], tablets[i + 1] + 1);

        long ans = 0;
        for (int x : tablets) ans += x;

        System.out.println(ans);
    }
}
