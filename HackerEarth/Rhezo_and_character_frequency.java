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
                if (len == -1) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ' && c != -1);
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ' && c != -1);
            int num = 0;
            while (c > ' ') {
                num = num * 10 + c - '0';
                c = read();
            }
            return num;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        String s = fs.next();
        char ch = fs.next().charAt(0);
        int p = fs.nextInt();

        int n = s.length();

        int count = 0;
        int maxFreq = 0;

        // Find maximum frequency in all windows of length p
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) count++;

            if (i >= p && s.charAt(i - p) == ch) count--;

            if (i >= p - 1)
                maxFreq = Math.max(maxFreq, count);
        }

        if (maxFreq == p) {
            System.out.println(-1);
            return;
        }

        int window = p - 1;
        count = 0;
        int ans = -1;

        // Find last window of length p-1 having maxFreq occurrences
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) count++;

            if (i >= window && s.charAt(i - window) == ch) count--;

            if (i >= window - 1 && count == maxFreq)
                ans = i + 1;
        }

        System.out.println(ans);
    }
}
