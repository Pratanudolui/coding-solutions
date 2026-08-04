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
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int maxDay = 0;
        int maxOverall = 0;
        int carry = 0;

        for (int d = 0; d < n; d++) {
            String s = fs.next();

            int cur = 0;
            int best = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'C') {
                    cur++;
                    best = Math.max(best, cur);
                } else {
                    cur = 0;
                }
            }

            maxDay = Math.max(maxDay, best);

            int prefix = 0;
            while (prefix < s.length() && s.charAt(prefix) == 'C') prefix++;

            int suffix = 0;
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == 'C') {
                suffix++;
                i--;
            }

            maxOverall = Math.max(maxOverall, best);

            if (d > 0) {
                maxOverall = Math.max(maxOverall, carry + prefix);
            }

            if (suffix == s.length()) {
                carry += suffix;
            } else {
                carry = suffix;
            }
        }

        System.out.println(maxDay + " " + maxOverall);
    }
}
