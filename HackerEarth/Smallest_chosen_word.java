import java.io.InputStream;

public class TestClass {

    // Fast Scanner for IO efficiency
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

        public String next() {
            if (!hasNext()) return null;
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (b > ' ') {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        if (!fs.hasNext()) return;

        int n1 = fs.nextInt();
        int n2 = fs.nextInt();
        int n3 = fs.nextInt();

        String s1 = fs.next();
        String s2 = fs.next();
        String s3 = fs.next();

        char firstChar = s3.charAt(0);
        boolean allowEqual = false;

        // Determine if we should accept characters in s2 equal to s3[0]
        for (int i = 1; i < n3; i++) {
            if (s3.charAt(i) != firstChar) {
                if (s3.charAt(i) > firstChar) {
                    allowEqual = true;
                }
                break;
            }
        }

        // Build suffix minimum array for s2
        char[] suffixMin = new char[n2];
        suffixMin[n2 - 1] = s2.charAt(n2 - 1);
        for (int i = n2 - 2; i >= 0; i--) {
            suffixMin[i] = (char) Math.min(s2.charAt(i), suffixMin[i + 1]);
        }

        // Construct greedy subsequence x from s2
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            char c = s2.charAt(i);
            if (c == suffixMin[i]) {
                if (c < firstChar || (c == firstChar && allowEqual)) {
                    x.append(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(s1).append(x).append(s3);

        System.out.println(result.toString());
    }
}
