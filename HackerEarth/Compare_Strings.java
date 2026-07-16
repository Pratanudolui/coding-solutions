import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
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
            while ((c = read()) <= ' ');
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

        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();
        int Q = fs.nextInt();

        char[] A = fs.next().toCharArray();
        char[] B = fs.next().toCharArray();

        TreeSet<Integer> diff = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            if (A[i] != B[i]) diff.add(i);
        }

        StringBuilder out = new StringBuilder();

        while (Q-- > 0) {
            int idx = fs.nextInt() - 1;

            if (B[idx] == '0') {
                B[idx] = '1';
                if (A[idx] == B[idx]) {
                    diff.remove(idx);
                } else {
                    diff.add(idx);
                }
            }

            if (diff.isEmpty()) {
                out.append("YES\n");
            } else {
                int first = diff.first();
                if (B[first] > A[first]) {
                    out.append("YES\n");
                } else {
                    out.append("NO\n");
                }
            }
        }

        System.out.print(out);
    }
}
