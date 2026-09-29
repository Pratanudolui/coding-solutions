import java.io.InputStream;

public class TestClass {

    private static boolean canBePalindromeWithOneSwap(String str) {
        char[] s = str.toCharArray();
        int n = s.length;

        int[] mismatchIndices = new int[n];
        int count = 0;

        for (int i = 0; i < n / 2; i++) {
            if (s[i] != s[n - 1 - i]) {
                mismatchIndices[count++] = i;
            }
        }

        // Already a palindrome
        if (count == 0) return true;

        // More than 2 mismatched pairs cannot be fixed in 1 swap
        if (count > 2) return false;

        int p1 = mismatchIndices[0];
        int p1Pair = n - 1 - p1;

        if (count == 1) {
            // Case 1: If N is odd, try swapping with middle element
            if (n % 2 != 0) {
                int mid = n / 2;
                
                // Swap p1 and mid
                if (s[mid] == s[p1Pair]) return true;
                // Swap p1Pair and mid
                if (s[mid] == s[p1]) return true;
            }

            // Case 2: Try swapping s[p1] or s[p1Pair] with any other character s[k]
            for (int k = 0; k < n; k++) {
                if (k == p1 || k == p1Pair) continue;

                // If swapping s[p1] with s[k] fixes s[p1] and doesn't break position k
                if (s[k] == s[p1Pair] && s[p1] == s[n - 1 - k]) return true;

                // If swapping s[p1Pair] with s[k] fixes s[p1Pair] and doesn't break position k
                if (s[k] == s[p1] && s[p1Pair] == s[n - 1 - k]) return true;
            }

            return false;
        }

        // count == 2
        int p2 = mismatchIndices[1];
        int p2Pair = n - 1 - p2;

        // Option A: Swap s[p1] with s[p2] or s[p2Pair]
        if (s[p1] == s[p2Pair] && s[p2] == s[p1Pair]) return true;
        if (s[p1] == s[p2] && s[p2Pair] == s[p1Pair]) return true;

        // Option B: Swap s[p1Pair] with s[p2] or s[p2Pair]
        if (s[p1Pair] == s[p2Pair] && s[p2] == s[p1]) return true;
        if (s[p1Pair] == s[p2] && s[p2Pair] == s[p1]) return true;

        return false;
    }

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

        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String s = fs.next();
            if (canBePalindromeWithOneSwap(s)) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb);
    }
}
