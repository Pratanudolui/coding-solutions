import java.io.InputStream;
import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        if (t == 0) return;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt() % 16;
            char dir = fs.nextChar();

            int result;
            if (dir == 'L') {
                result = ((n << m) | (n >>> (16 - m))) & 0xFFFF;
            } else {
                result = ((n >>> m) | (n << (16 - m))) & 0xFFFF;
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb.toString());
    }

    // High-performance byte reader to eliminate String parsing overhead
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[32768];
        private int ptr = 0;
        private int buflen = 0;

        private int read() {
            if (ptr >= buflen) {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                if (buflen <= 0) return -1;
            }
            return buffer[ptr++];
        }

        public int nextInt() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return 0;
                c = read();
            }
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public char nextChar() {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            return (char) c;
        }
    }
}
