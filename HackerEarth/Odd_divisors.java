import java.io.*;

public class TestClass {

    // Computes sum of greatest odd divisors S(N) % M in O(log N)
    private static long solve(long n, long m) {
        if (n <= 0) return 0;
        
        long k = (n + 1) / 2;
        long oddSum = ((k % m) * (k % m)) % m;
        
        return (oddSum + solve(n / 2, m)) % m;
    }

    // Fast Scanner for I/O performance
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024 * 64];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer, 0, buffer.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private int readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        public boolean hasNext() {
            int b = readByte();
            while (b != -1 && b <= ' ') {
                b = readByte();
            }
            if (b == -1) return false;
            ptr--;
            return true;
        }

        public long nextLong() {
            int b = readByte();
            while (b <= ' ') {
                if (b == -1) return -1;
                b = readByte();
            }
            long res = 0;
            while (b > ' ') {
                if (b < '0' || b > '9') {
                    b = readByte();
                    continue;
                }
                res = res * 10 + (b - '0');
                b = readByte();
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        if (!fs.hasNext()) return;

        int t = (int) fs.nextLong();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = fs.nextLong();
            long m = fs.nextLong();

            sb.append(solve(n, m)).append("\n");
        }

        System.out.print(sb);
    }
}
