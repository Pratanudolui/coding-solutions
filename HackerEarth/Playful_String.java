import java.io.InputStream;

public class TestClass {

    // Returns true if 'sub' is a subsequence of 's'
    private static boolean isSubsequence(String s, String sub) {
        int n = s.length();
        int m = sub.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == m;
    }

    // Fast Scanner for I/O efficiency
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

        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String s = fs.next();
            String target = fs.next();

            String revTarget = new StringBuilder(target).reverse().toString();

            boolean isSub1 = isSubsequence(s, target);
            boolean isSub2 = isSubsequence(s, revTarget);

            if (isSub1 && isSub2) {
                sb.append("GOOD STRING\n");
            } else {
                sb.append("BAD STRING\n");
            }
        }

        System.out.print(sb);
    }
}
