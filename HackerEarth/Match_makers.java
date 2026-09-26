import java.io.InputStream;
import java.util.Arrays;

public class TestClass {

    // Fast Scanner class that handles arbitrary whitespace and newlines safely
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
            ptr--; // Step back to re-read the non-whitespace character
            return true;
        }

        public int nextInt() {
            int b = readByte();
            while (b <= ' ') {
                if (b == -1) return -1;
                b = readByte();
            }
            int res = 0;
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
        FastScanner scanner = new FastScanner();
        if (!scanner.hasNext()) return;

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            int[] girls = new int[n];
            int[] boys = new int[n];

            for (int i = 0; i < n; i++) {
                girls[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                boys[i] = scanner.nextInt();
            }

            // Sort girls in ascending order
            Arrays.sort(girls);

            // Sort boys in ascending order first
            Arrays.sort(boys);

            int idealPairs = 0;

            // Match girls[i] with boys[n - 1 - i] (equivalent to reverse/descending order for boys)
            for (int i = 0; i < n; i++) {
                int girlHeight = girls[i];
                int boyHeight = boys[n - 1 - i];

                if (girlHeight % boyHeight == 0 || boyHeight % girlHeight == 0) {
                    idealPairs++;
                }
            }

            System.out.println(idealPairs);
        }
    }
}
