import java.io.*;

public class Main {

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

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] group = new int[N + 1];

        for (int i = 1; i <= K; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int x = sc.nextInt();
                group[x] = i;
            }
        }

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int diff = Math.abs(group[x] - group[y]);
            sb.append(Math.min(diff, K - diff)).append('\n');
        }

        System.out.print(sb);
    }
}
