import java.io.*;

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

        public String next() {
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (b <= ' ') {
                if (b == -1) return null;
                b = readByte();
            }
            while (b > ' ') {
                sb.append((char) b);
                b = readByte();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        String s = fs.next();
        if (s == null || s.isEmpty()) return;

        char[] arr = s.toCharArray();
        int n = arr.length;

        
        char[] blockChars = new char[n];
        long[] blockCounts = new long[n];
        int blockCount = 0;

        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && arr[j] == arr[i]) {
                j++;
            }
            blockChars[blockCount] = arr[i];
            blockCounts[blockCount] = j - i;
            blockCount++;
            i = j;
        }

        long totalSpecialSubstrings = 0;

        
        for (int i = 0; i < blockCount; i++) {
            long k = blockCounts[i];
            totalSpecialSubstrings += (k * (k + 1)) / 2;
        }

       
        for (int i = 1; i < blockCount - 1; i++) {
            if (blockCounts[i] == 1 && blockChars[i - 1] == blockChars[i + 1]) {
                totalSpecialSubstrings += Math.min(blockCounts[i - 1], blockCounts[i + 1]);
            }
        }

        System.out.println(totalSpecialSubstrings);
    }
}
