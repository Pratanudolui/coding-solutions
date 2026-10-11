import java.io.*;
import java.util.*;

public class TestClass {

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
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            String s = fs.next();
            int n = s.length();
            char[] ans = new char[n];

            List indices = new ArrayList<>(n);
            for (int i = 0; i < n; i++) indices.add(i);

            for (int i = 0; i < n; i++) {
                int size = indices.size();
                int mid;
                if (size % 2 != 0) {
                    mid = size / 2;
                } else {
                    mid = (size / 2) - 1;
                }
                int originalIdx = indices.get(mid);
                ans[originalIdx] = s.charAt(i);
                indices.remove(mid);
            }

            out.append(new String(ans)).append("\n");
        }

        System.out.print(out);
    }
}
