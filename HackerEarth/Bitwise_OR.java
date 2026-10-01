import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    // Helper class to store subarray indices
    static class Subarray {
        int l, r;
        Subarray(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    private static void addNumber(int num, int[] bitCounts) {
        for (int i = 0; i < 30; i++) {
            if (((num >> i) & 1) == 1) {
                bitCounts[i]++;
            }
        }
    }

    private static void removeNumber(int num, int[] bitCounts) {
        for (int i = 0; i < 30; i++) {
            if (((num >> i) & 1) == 1) {
                bitCounts[i]--;
            }
        }
    }

    private static int getCurrentOR(int[] bitCounts) {
        int currentOR = 0;
        for (int i = 0; i < 30; i++) {
            if (bitCounts[i] > 0) {
                currentOR |= (1 << i);
            }
        }
        return currentOR;
    }

    private static void solve(int n, long x, int[] a, StringBuilder sb) {
        int[] bitCounts = new int[30];
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < n; right++) {
            addNumber(a[right], bitCounts);

            while (left <= right && getCurrentOR(bitCounts) >= x) {
                int currentLen = right - left + 1;
                if (currentLen < minLength) {
                    minLength = currentLen;
                }
                removeNumber(a[left], bitCounts);
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            sb.append(0).append("\n");
            return;
        }

        // Find all subarrays of length minLength whose OR >= x
        List<Subarray> result = new ArrayList<>();
        bitCounts = new int[30];

        for (int i = 0; i < minLength - 1; i++) {
            addNumber(a[i], bitCounts);
        }

        for (int right = minLength - 1; right < n; right++) {
            addNumber(a[right], bitCounts);

            int leftIdx = right - minLength + 1;
            if (getCurrentOR(bitCounts) >= x) {
                result.add(new Subarray(leftIdx + 1, right + 1)); // 1-based indexing
            }

            removeNumber(a[leftIdx], bitCounts);
        }

        sb.append(result.size()).append("\n");
        for (Subarray sub : result) {
            sb.append(sub.l).append(" ").append(sub.r).append("\n");
        }
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

        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            long x = fs.nextLong();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            solve(n, x, a, sb);
        }

        System.out.print(sb);
    }
}
