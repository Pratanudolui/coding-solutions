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

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ' && c != -1);
            if (c == -1) return -1;
            long res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        long[] price = new long[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextLong();
        }

        if (m == 0) {
            long minPrice = price[0];
            for (int i = 1; i < n; i++) {
                minPrice = Math.min(minPrice, price[i]);
            }
            System.out.println(minPrice - 1);
            return;
        }

        // Sum of the first m items
        long sumFirstM = 0;
        for (int i = 0; i < m; i++) {
            sumFirstM += price[i];
        }

        // Find the minimum price among the remaining items (m to n-1)
        long minRemaining = Long.MAX_VALUE;
        for (int i = m; i < n; i++) {
            minRemaining = Math.min(minRemaining, price[i]);
        }

        // Maximum wealth = sum of first m items + (minRemaining - 1)
        long maxWealth = sumFirstM + (minRemaining - 1);
        System.out.println(maxWealth);
    }
}
